class Solution {
    HashMap<String , Integer> dp = new HashMap<>() ;
    int MOD = 1000000007;
    public int backtrack( int n , int k , int t ) {
        if( t == 0 && n == 0) return 1 ;
        if( t < 0 ) return 0 ;
        if( n <= 0 ) return 0 ;

        String key = n + "-" + k + "-" + t ;

        if( dp.containsKey( key ) ) return dp.get(key) ;

        int count = 0 ;
        for( int i = 1 ; i <= k ; i++ ) {
            count = (count + backtrack(n - 1, k, t - i)) % MOD;
        } 

        dp.put( key , count ) ;
        return count ;
    }
    public int numRollsToTarget(int n, int k, int target) {
        return backtrack( n , k  , target ) ;
    }
}