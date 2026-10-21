class Solution {
    public int trap(int[] height) {
        int n = height.length ;
        int max = 0 ;
        int[] maxL = new int[n] ;
        int[] maxR = new int[n] ;
        maxL[0] = height[0] ;
        max = height[0] ;
        for( int i = 1 ; i < height.length ; i++ ) {
            if( max < height[i] ) {
                max = height[i] ;
            }
            maxL[i] = max ;
        }
        maxR[n-1] = height[n-1] ;
        max = height[n-1] ;
        for( int i = n - 2 ; i >= 0 ; i-- ) {
            if( max < height[i] ) {
                max = height[i] ;
            }
            maxR[i] = max ;
        }
        int sum = 0 ;
        for( int i = 0 ; i < height.length ; i++ ) {
            sum += (Math.min( maxL[i] , maxR[i] ) - height[i]) ;
        }
        return sum ;
    }
}