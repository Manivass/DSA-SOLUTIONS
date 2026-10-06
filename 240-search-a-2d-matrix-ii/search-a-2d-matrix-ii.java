class Solution {
    public boolean searchMatrix(int[][] matrix, int t) {
        int row = 0;
        int col = matrix[0].length - 1;
        while ( row < matrix.length && col >= 0 ) {
            int val = matrix[row][col];
            if (val == t)
                return true ;
            else if (val > t) {
                col--;
            } else
                row++;
        }
        return false ;
    }
}