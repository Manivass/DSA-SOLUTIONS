class Solution {
    List<List<String>> ans = new ArrayList<>() ;
    public void backtrack( int row , char[][] board , HashSet<Integer> cols , HashSet<Integer> diagonal , HashSet<Integer> antidiagonal  ) {
        if( row == board.length ) {
            List<String> str = new ArrayList<>() ;
            for( char[] ch : board ) {
                String subAns = "" ;
                for( char chrs : ch ) {
                    subAns = subAns + chrs ;
                }
                str.add(subAns) ;
            }
            ans.add( new ArrayList<>(str) ) ;
            return ;
        }
        for( int col = 0 ; col < board.length ; col++ ) {
            if( cols.contains(col) || diagonal.contains( row - col ) || antidiagonal.contains( row + col ) ) continue ;
            board[row][col] = 'Q' ;
            cols.add( col ) ;
            diagonal.add( row - col ) ;
            antidiagonal.add( row + col ) ;
            backtrack( row + 1 , board , cols , diagonal , antidiagonal ) ;
            cols.remove( col ) ;
            diagonal.remove( row - col ) ;
            antidiagonal.remove( row + col ) ;
            board[row][col] = '.' ;
        }
    }
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n] ;
        for( int i = 0 ; i < n ; i++ ) {
            for( int j = 0 ; j < n ; j++ ) {
                board[i][j] = '.' ;
            }
        }
        HashSet<Integer> col = new HashSet<>() ;
        HashSet<Integer> diagonal = new HashSet<>() ;
        HashSet<Integer> antidiagonal = new HashSet<>() ;
        backtrack( 0 , board , col , diagonal , antidiagonal ) ;
        return ans ; 
    }
}