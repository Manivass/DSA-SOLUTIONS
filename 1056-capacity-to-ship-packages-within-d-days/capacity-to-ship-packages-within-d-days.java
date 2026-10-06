class Solution {
    public int totDays( int[] arr , int t ) {
        int tot = 1 ;
        int sum = 0 ;
        for( int num : arr ) {
            if( sum + num <= t ) {
                sum+=num ;
            }
            else if( num > t ) {
                return Integer.MAX_VALUE ;
            }
            else {
                tot++ ;
                sum = num ;
            }
        }
        return tot ;
    }
    public int shipWithinDays(int[] arr, int days) {
        int max = 0;
        for( int num : arr ) {
            max = Math.max( max , num ) ;
        }
        int l = 1 ;
        int r = Integer.MAX_VALUE ;
        while( l < r ) {
            int m = l + ( r - l ) / 2 ;
            int getTot = totDays( arr , m ) ;
            if( getTot <= days ) {
                r = m ;
            }
            else l = m + 1 ;
        }
        return r ; 
    }
}