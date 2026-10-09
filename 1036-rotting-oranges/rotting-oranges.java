class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>() ;
        int m = grid.length ;
        int n = grid[0].length ;
        for( int i = 0 ; i < m ; i++ ) {
            for( int j = 0 ; j < n ; j++ ) {
                if( grid[i][j] == 2 ) q.offer( new int[] { i , j , 0 } ) ;
            }
        }
        int max = 0 ;
        while( !q.isEmpty() ) {
            int[] curr = q.poll() ;
            int row = curr[0] ;
            int col = curr[1] ;
            int time = curr[2] ;
            int[] dr = { -1 , 1 , 0 , 0 } ;
            int[] dc = { 0 , 0, -1 , 1 } ;
            for( int k = 0 ; k < 4 ; k++ ) {
                int newRow = dr[k] + row ;
                int newCol = dc[k] + col ;
                if( newRow < 0 || newRow >= m || newCol < 0 || newCol >= n ) continue ;
                if( grid[newRow][newCol] != 1 ) continue ;
                grid[newRow][newCol] = 2 ;
                 max = Math.max( max , time + 1 ) ;
                q.offer( new int[] { newRow , newCol , time + 1 } ) ; 
            }
        }
        for( int[] arr : grid ) {
            for( int num : arr ) if( num == 1 ) return -1 ;
        }
        return max ;
    }
}