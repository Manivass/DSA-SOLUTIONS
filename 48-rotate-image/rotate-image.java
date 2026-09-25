class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length ;
        HashSet<String> set = new HashSet<>() ;
        for( int i = n - 1 ; i >= 0 ; i-- ) {
            for( int j = 0 ; j < n ; j++ ) {
                String key1 = i + "-" + j ;
                String key2 = j + "-" + i ;
                if( set.contains( key1 ) || set.contains(key2) ) continue ;
                set.add(key1) ;
                set.add(key2) ;
                int temp = matrix[i][j] ;
                matrix[i][j] = matrix[j][i] ;
                matrix[j][i] = temp ;
            }   
        }
        for( int i = 0 ; i < n ; i++ ) {
            int left = 0 ;
            int right = n - 1 ;
            while( left < right ) {
                int temp = matrix[i][left] ;
                matrix[i][left] = matrix[i][right] ;
                matrix[i][right] = temp ;
                left++ ;
                right-- ;
            }

        }
    }
}