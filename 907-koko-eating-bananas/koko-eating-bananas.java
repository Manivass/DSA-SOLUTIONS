class Solution {
    public int getSum( int i , int[] arr ) {
        int sum = 0 ;
        for( int num : arr ) sum+=(int) Math.ceil((double)num/i) ;
        return sum ;
    }
    public int minEatingSpeed(int[] nums, int h) {
        int max = 0;
        for(  int num : nums ) max = Math.max( max , num ) ;
        int l = 1 ;
        int r = max ;
        while( l < r ) {
            int m = l + ( r - l ) / 2 ;
            int sum = getSum( m , nums ) ;
            if( sum <= h ) {
                r = m ;
            }
            else l = m + 1 ;
        }
        return r ;
    }
}