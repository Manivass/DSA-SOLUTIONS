class Solution {
    int cnt = 0 ;
    public void backtrack( int row , char[][] board ,  HashSet<Integer> cols , HashSet<Integer> diagonal ,  HashSet<Integer> antidiagonal ) {
        if( row == board.length ) {
            cnt++ ;
            return ; 
        }
        for( int col = 0 ; col < board.length ; col++ ) {
            if( cols.contains( col ) || diagonal.contains( row + col ) || antidiagonal.contains( row - col ) ) continue ;
            board[row][col] = 'Q' ;
            cols.add(col) ;
            diagonal.add( row + col ) ;
            antidiagonal.add( row - col ) ;
            backtrack( row + 1 , board , cols ,diagonal ,antidiagonal  ) ;
            cols.remove( col ) ;
            diagonal.remove( row + col ) ;
            antidiagonal.remove( row - col ) ;
            board[row][col] = '.' ;
        }
    }
    public int totalNQueens(int n) {
        char[][] board = new char[n][n] ;
        for( int i = 0 ; i < n ; i++ ) {
            for( int j = 0 ; j < n ; j++ ) {
                board[i][j] = '.' ;
            }
        }
        HashSet<Integer> cols = new HashSet<>() ;
        HashSet<Integer> diagonal = new HashSet<>() ;
        HashSet<Integer> antidiagonal = new HashSet<>() ;
        backtrack( 0 , board ,  cols , diagonal , antidiagonal ) ;
        return cnt ; 
    }
}