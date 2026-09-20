class Solution {
    public int minimumEffortPath(int[][] grid) {
        int m = grid.length ;
        int n = grid[0].length ;
        int[][] dist =  new int[m][n] ;
        for( int i = 0 ; i < m ; i++ ) {
            for( int j = 0 ; j < n ; j++ ) dist[i][j] = Integer.MAX_VALUE ;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(( a , b  ) -> Integer.compare(a[2],b[2])) ;
        dist[0][0] = 0 ;
        pq.offer(new int[] { 0 , 0 , 0 } ) ;
        while( !pq.isEmpty() ) {
            int[] curr = pq.poll() ;
            int row = curr[0] ;
            int col = curr[1] ;
            int diff = curr[2] ;
            int[] dr = { -1 , 1 , 0 , 0 } ;
            int[] dc = { 0 , 0 , -1 , 1 } ;
            for( int i = 0 ; i < 4 ; i++ ) {
                int r = dr[i] + row ;
                int c = dc[i] + col ;
                if( r < 0 || r >= m || c < 0 || c >= n ) continue ;
                int newDiff = Math.max( diff , Math.abs( grid[r][c] - grid[row][col] ) ) ;
                if( newDiff < dist[r][c] ) {
                    dist[r][c] = newDiff ;
                    pq.offer( new int[] { r , c , newDiff } ) ;
                }
            }
        }
        return dist[m-1][n-1] == Integer.MAX_VALUE ? -1 : dist[m-1][n-1]  ;
    }
}