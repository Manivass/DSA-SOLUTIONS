class Solution {
    boolean[][] visited ;
    public boolean backtrack( char[][] board , int row , int col , String word , int index ) {
        if( visited[row][col] ) return false ;
        if( index == word.length() ) return true ;
        visited[row][col] = true ;
        int[] dr = { 0 , 0 , -1 , 1 } ;
        int[] dc = { -1 , 1 , 0 , 0 } ;
        boolean subAns = false ;
        for( int i = 0 ; i < 4 ; i++ ) {
            int newRow = dr[i] + row ;
            int newCol = dc[i] + col ;
            if( newRow < 0 || newRow >= board.length || newCol < 0 || newCol >= board[0].length ) continue ;
            if( visited[newRow][newCol] ) continue ;
            if( board[newRow][newCol] != word.charAt(index) ) continue ;
            subAns = subAns || backtrack( board , newRow , newCol , word , index + 1 ) ;
        }
        visited[row][col] = false ;
        return subAns ;
    }
    public boolean exist(char[][] board, String word) {
        int m = board.length ;
        int n = board[0].length ;
        visited = new boolean[m][n] ;
        for( int i = 0 ; i < m ; i++ ) {
            for( int j = 0 ; j < n ; j++ ) {
                if( board[i][j] == word.charAt(0) ) {
                    boolean ans = backtrack( board , i , j , word , 1 ) ;
                    if( ans ) return true ;
                }
            }
        }
        return false ; 
    }
}