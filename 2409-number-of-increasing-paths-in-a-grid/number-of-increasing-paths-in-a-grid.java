class Solution {

    long MOD = 1000000007;
    int[][] dp ;

    public int backtrack(int[][] grid, int i, int j, boolean[][] visited) {
        if( dp[i][j] != -1 ) return dp[i][j] ;
        long count = 1;
        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };
        for (int k = 0; k < 4; k++) {
            int row = dr[k] + i;
            int col = dc[k] + j;
            if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length)
                continue;
            if (grid[i][j] >= grid[row][col])
                continue;
            if (visited[row][col])
                continue;
            visited[row][col] = true;

            count += backtrack(grid, row, col, visited);

            count %= MOD;
            visited[row][col] = false ;
        }
        dp[i][j] = (int) count ;
        return dp[i][j] ;
    }

    public int countPaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new int[m][n] ;
        for( int i = 0 ; i < m ; i++ ) Arrays.fill(dp[i] , - 1) ;
        long count = 0 ;
        for (int i = 0; i < m; i++) {
            boolean[][] visited = new boolean[m][n];
            for (int j = 0; j < grid[0].length; j++) {
                visited[i][j] = true;
                count+=backtrack(grid, i, j, visited);
                count%=MOD ;
                visited[i][j] = false;
            }
        }
        return (int)count ;
    }
}