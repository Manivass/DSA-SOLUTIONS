class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>() ;
        int n = intervals.length ;
        int i = 0 ;
        while( i < n ) {
            if( intervals[i][1] >= newInterval[0]  ) break ;
            list.add(intervals[i]) ;
            i++ ;
        }
        int[] sbArr = newInterval ;

        while( i < n && intervals[i][0] <= newInterval[1] ) {
            sbArr[0] = Math.min(sbArr[0] , intervals[i][0]) ;
            sbArr[1] = Math.max( sbArr[1] , intervals[i][1] ) ;
            i++ ;
        }
        list.add(sbArr) ;
        while( i < n ) {
            list.add( intervals[i] ) ;
            i++ ;
        }
        int[][] ans = new int[list.size()][2] ;
        int k = 0 ;
        for( int[] num : list ) {
            ans[k++] = num ;
        }
        return ans ;
    }
}