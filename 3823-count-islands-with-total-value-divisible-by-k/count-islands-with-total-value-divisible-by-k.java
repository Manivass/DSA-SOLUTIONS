class Solution {
    public long bfs(int[][] grid, int i, int j, boolean[][] visited) {
        if (grid[i][j] == 0)
            return 0;
        if (visited[i][j])
            return 0;
        visited[i][j] = true;
        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };
        long sum = 0;
        for (int k = 0; k < 4; k++) {
            int row = dr[k] + i;
            int col = dc[k] + j;
            if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length)
                continue;
            if (visited[row][col])
                continue;
            sum += bfs(grid, row, col, visited);
        }
        return grid[i][j] + sum;
    }

    public int countIslands(int[][] grid, int k) {
        int m = grid.length ;
        int n = grid[0].length ;
        boolean[][] visited = new boolean[m][n] ;
        List<Long> list = new ArrayList<>() ;
        for( int i = 0 ; i < m ; i++ ) {
            for( int j = 0 ; j < n ; j++ ) {
                if( grid[i][j] != 0 && !visited[i][j] ) {
                    list.add( bfs( grid , i , j , visited ) ) ;
                } 
            }
        }
        
        int cnt = 0 ;
        
        for( long area : list ) {
            if( area % k == 0 ) cnt++ ;
        }
        return cnt ;
    }
}