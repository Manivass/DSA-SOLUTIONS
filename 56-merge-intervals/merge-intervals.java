class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>() ;
        Arrays.sort( intervals , ( a , b ) -> a[0] - b[0] ) ;
        list.add(intervals[0]) ;
        for( int i = 1 ; i < intervals.length ; i++ ) {
            int[] last = list.get( list.size() - 1 ) ;
            if( last[1] >= intervals[i][0] ) {
                last[1] = Math.max( last[1] , intervals[i][1] ) ;
            }
            else {
                list.add( intervals[i] ) ;
            }
        }

        int[][] ans = new int[list.size()][2] ;
        int k = 0 ;
        for( int[] num : list ) {
            ans[k][0] = num[0] ;
            ans[k][1] = num[1] ;
            k++ ;
        }
        return ans ;
    }
    
}