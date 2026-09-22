class Solution {
    public void solve(char[][] board) {
        int m = board.length ;
        int n = board[0].length ;
        boolean[][] visited = new boolean[m][n] ;
        Queue<int[]> q = new ArrayDeque<>() ;
        for( int i = 0 ; i < m ; i++ ) {
            for( int j = 0 ; j < n ; j++ ) {
                if( i == 0 || i == m -1 || j == 0 || j == n - 1 ) {
                    if( board[i][j] == 'O' ) {
                        q.offer( new int[] { i , j } ) ;
                        visited[i][j] = true ;
                    }
                }
            }
        }
        while( !q.isEmpty() ) {
            int[] curr = q.poll() ;
            int[] dr = { -1 , 1 ,0 , 0 } ;
            int[] dc = { 0 , 0 , - 1 , 1 } ;
            for( int i = 0 ; i < 4 ; i++ ) {
                int row = dr[i] + curr[0] ;
                int col = dc[i] + curr[1] ;
                if( row < 0 || row >= m || col < 0 || col >= n ) continue ;
                if( visited[row][col] != false ) continue ;
                if( board[row][col] == 'O' ) {
                    q.offer( new int[] { row , col } ) ;
                    visited[row][col] = true ;
                }
            }
        }
        for( int i = 0 ; i < m ; i++ ) {
            for( int j = 0 ; j < n ; j++ ) {
                if( board[i][j] == 'O' && visited[i][j] == false  ) board[i][j] = 'X' ;
            }
        }
    }
}