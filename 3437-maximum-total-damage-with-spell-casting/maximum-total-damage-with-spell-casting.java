class Solution {
    HashMap<Integer , Long> dp = new HashMap<>() ;
    int[] value ;
    long[] gain ;

    public long backtrack( int i ) {
        if( i >= value.length ) return 0 ;

        long max = 0 ;
        if( dp.containsKey(i) ) return dp.get(i) ;

        long skip = backtrack( i + 1 ) ;

        long take = gain[i] ;

        int j = i + 1 ;

        while( j < value.length && value[j] <= value[i]+2 ) {
            j++ ;
        }

        take += backtrack(j) ;

        max = Math.max( skip , take ) ;

        dp.put( i , max ) ;

        return max ;

    }
    public long maximumTotalDamage(int[] power) {
        Arrays.sort(power) ;

        ArrayList<Integer> v = new ArrayList<>() ;
        ArrayList<Long> g = new ArrayList<>() ;

        int i = 0 ;
        while( i < power.length ) {
            long sum = 0  ;
            int x = power[i] ;
            while( i < power.length && power[i] == x ) {
                sum+= x ;
                i++;
            }
            v.add( x ) ;
            g.add( sum ) ;
        } 
        value = new int[v.size()] ;
        gain = new long[g.size()] ;

        for( i = 0 ; i < value.length ; i++ ) {
            value[i] = v.get(i) ;
            gain[i] = g.get(i) ;
        }

        return backtrack(0) ;
    }
}