class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort( intervals , ( a , b ) -> ( a[1] - b[1] ) ) ;
        int cnt = 0 ;
        int k = intervals[0][1] ;
        for( int i = 1 ; i < intervals.length ; i++ ) {
            if( k > intervals[i][0] ) cnt++ ;
            else k = intervals[i][1] ;
        }
        return cnt ; 
    }
}