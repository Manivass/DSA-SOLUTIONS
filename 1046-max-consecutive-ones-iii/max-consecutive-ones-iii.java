class Solution {
    public int longestOnes(int[] arr, int k) {
        int i = 0 ;
        int j = 0 ;
        int maxWindow = 0 ;
        while( j < arr.length ) {
            if( arr[j] == 0 ) k-- ;
            while( k < 0 ) {
                if( arr[i] == 0 ) k++;
                i++ ;
            }
            maxWindow = Math.max( maxWindow , j - i + 1 ) ;
            j++ ;
        }
        return maxWindow ;
    }
}