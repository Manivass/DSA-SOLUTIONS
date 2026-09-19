class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if( grid[0][0] != 0 ) return -1 ;
        if( grid[m-1][n-1] != 0 ) return -1 ;
        if( m == 1 && n == 1 ) return 1 ;
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++)
            Arrays.fill(dist[i], -1);
        Queue<int[]> q = new ArrayDeque<>();
        dist[0][0] = 0;
        q.offer(new int[] { 0, 0 });
        HashSet<String> set = new HashSet<>() ;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int frst = curr[0] ;
            int second = curr[1] ;
            int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
            int[] dc = { 0, 0, -1, 1, -1, 1 , - 1, 1 };
            for( int i = 0 ; i < 8 ; i++ ) {
                int row = dr[i] + curr[0] ;
                int col = dc[i] + curr[1] ;
                if( row < 0 || row >= m || col < 0 || col >= n ) continue ;

                if( grid[row][col] != 0 ) continue ;

                set.add( row + "-" + col ) ;

                if( dist[row][col] == -1 ) {
                    dist[row][col] = dist[frst][second] + 1 ;
                    q.offer( new int[] { row , col } ) ;
                }
            }
        }
        return set.contains((m-1)+"-"+(n-1)) ? dist[m-1][n-1]+1 : -1 ;
    }
}