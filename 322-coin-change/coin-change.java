class Solution {
    HashMap<Integer , Integer> dp = new HashMap<>() ;
    public  int backtrack( int[] arr , int t ) {
        if( t == 0 ) return 0 ;
        if( t < 0 ) return Integer.MAX_VALUE ;
        if( dp.containsKey( t ) ) return dp.get(t) ;
        int min = Integer.MAX_VALUE ;
        for( int i = 0 ; i < arr.length ; i++ ) {
            int res = backtrack( arr , t - arr[i] ) ;
            if( res != Integer.MAX_VALUE ) {
                min = Math.min( min , 1 + res ) ;
            }
        }
        dp.put( t , min ) ; 
        return min ; 
    }
    public int coinChange(int[] coins, int amount) {
        int ans = backtrack( coins , amount ) ;
        return ans == Integer.MAX_VALUE ? -1 : ans ; 
    }
}