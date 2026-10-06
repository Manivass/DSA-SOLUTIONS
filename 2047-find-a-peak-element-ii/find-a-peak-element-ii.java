class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int index = 0;
            int mid = l + (r - l) / 2;
            int max = mat[0][mid];
            for (int i = 1; i < m; i++) {
                if (max < mat[i][mid]) {
                    max = mat[i][mid];
                    index = i;
                }
            }
            System.out.println(max) ;
            int left = mid > 0 ? mat[index][mid - 1] : -1;
            int right = mid < n - 1 ? mat[index][mid + 1] : -1;
            if( left > max ) r = mid - 1 ;
            else if( right > max ) l = mid + 1 ;
            else return new int[] { index , mid } ;
        }
        return new int[] { -1 , -1 } ;
    }
}