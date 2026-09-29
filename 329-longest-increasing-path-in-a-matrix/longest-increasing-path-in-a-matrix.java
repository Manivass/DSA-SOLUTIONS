class Solution {
    int[][] dp ;
    public int backtrack(int[][] grid , int i , int  j , boolean[][] visited ) {
        if( dp[i][j] != -1 ) return dp[i][j] ;
        int max = 0 ;
        int[] dr = { -1 , 1, 0 , 0 } ;
        int[] dc = { 0 , 0 ,-1 , 1 } ;
        for( int k = 0 ; k < 4 ; k++ ) {
            int row = dr[k] + i ;
            int col = dc[k] + j ;
            if( row < 0 || row >= grid.length || col < 0 || col >= grid[0].length ) continue ;
            if( grid[row][col] <= grid[i][j] ) continue ;
            if( visited[row][col] ) continue ;
            visited[row][col] = true ;
            max = Math.max(max ,1 + backtrack( grid , row , col , visited ) ) ;
            visited[row][col] = false ;
        }
        dp[i][j] = max ;
        return max ;
    }
    public int longestIncreasingPath(int[][] grid) {
        int m = grid.length ;
        int n = grid[0].length ;
        int max = 0 ;
        dp = new int[m][n] ;
        for( int i = 0 ; i < m ; i++ ) Arrays.fill( dp[i] , -1 ) ;
        for( int i = 0 ; i < m ; i++ ) {
            boolean[][] visited = new boolean[m][n] ;
            for( int j = 0 ; j < n ; j++ ) {
                visited[i][j] = true ;
                max = Math.max( max , 1 + backtrack( grid , i , j , visited ) ) ;
                visited[i][j] = false ;
            }
        }  
        return max ;  
    }
}