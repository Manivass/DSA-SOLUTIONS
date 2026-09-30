class Solution {
    int[][] dp ;
    public int backtrack(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n)
            return 0 ;
        if (grid[i][j] != '1')
            return 0;
        if( dp[i][j] != -1 ) return dp[i][j] ;
        int[] dr = { 1, 1, 0 };
        int[] dc = { 0, 1, 1 };
        int min = Integer.MAX_VALUE - 1;
        for (int k = 0; k < 3; k++) {
            int row = dr[k] + i;
            int col = dc[k] + j;
            int res = backtrack(grid, row, col);
            min = Math.min(min, res);
        }
        int ans = 1 + min ;
        dp[i][j] = ans == Integer.MAX_VALUE ? ans - 1 : ans ;
        return dp[i][j] ;
    }

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0 ;
        dp = new int[m][n] ;
        for( int i = 0 ; i < m ; i++ ) Arrays.fill(dp[i] , -1 ) ;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    int res = backtrack(matrix, i, j);
                    if( res != Integer.MAX_VALUE - 1 ) {
                        max = Math.max( max , res ) ;
                    }
                }
            }
        }   
        return max * max ;
    }
}