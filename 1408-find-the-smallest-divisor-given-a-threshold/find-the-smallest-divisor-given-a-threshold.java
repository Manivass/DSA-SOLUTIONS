class Solution {
    public int sumDiv( int n , int[] num ) {
        int sum = 0 ;
        for( int i = 0 ; i < num.length ; i++ ) {
            sum += (int) Math.ceil( (double) num[i] / n ) ;
        }
        return sum ;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int max = 0;
        for (int num : nums)
            max = Math.max(max, num);
        int l = 1 ;
        int r = max ;
        while( l < r ) {
            int m = l + ( r - l ) / 2 ;
            int sum = sumDiv( m , nums ) ;
            if( sum <= threshold ) {
                r = m ;
            }
            else l = m + 1 ;
        }
        return r ;
    }
}