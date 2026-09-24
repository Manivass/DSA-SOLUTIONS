class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length ;
        int n = matrix[0].length ;
        List<Integer> list = new ArrayList<>() ;
        int left = 0 ;
        int right = n - 1 ;
        int top = 0 ;
        int bottom = m - 1 ;
        while( left <= right && top <= bottom ) {
            for( int i = left ; i <= right ; i++ ) {
                list.add( matrix[top][i] ) ;
            }
            top++ ;
            for( int i = top ; i<= bottom ; i++ ) {
                list.add( matrix[i][right] ) ; 
            }
            right-- ;
            if( top <= bottom ) {
                for( int j = right ; j >= left ; j-- ) {
                    list.add( matrix[bottom][j] ) ;
                }
                bottom-- ;
            }
            if( left <= right ) {
                for( int j = bottom ; j >= top ; j-- ) {
                    list.add( matrix[j][left] ) ;
                }
                left++;
            }
        }
        return list ;

    }
}