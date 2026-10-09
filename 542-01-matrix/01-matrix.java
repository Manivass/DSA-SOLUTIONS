class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length ;
        int n = mat[0].length ;
        Queue<int[]> q = new ArrayDeque<>() ;
        for( int i = 0 ; i < m ; i++ ) {
            for( int j = 0 ; j < n ; j++ ) {
                if( mat[i][j] == 0 ) q.offer(new int[] { i , j }) ;
                else mat[i][j] = -1 ;
            }
        } 
        while( !q.isEmpty() ) {
            int[] curr = q.poll() ;
            int[] dr = { -1 , 1 , 0 , 0 } ;
            int[] dc = { 0 , 0 , - 1 , 1 } ;
            for( int i = 0 ; i < 4 ; i++ ) {
                int row = dr[i] + curr[0] ;
                int col = dc[i] + curr[1] ;
                if( row < 0 || row >= m || col < 0 || col >= n || mat[row][col] != -1 ) continue ;
                mat[row][col] = mat[curr[0]][curr[1]] + 1 ;
                q.offer( new int[] { row , col } ) ; 
            }
        }
        return mat ;
    }
}