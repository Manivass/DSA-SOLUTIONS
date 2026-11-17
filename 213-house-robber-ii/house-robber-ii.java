class Solution {
    public int maxDp( int[] arr , int st , int end ) {
        int n = end - st + 1 ;
        if( n == 0 ) return 0 ; 
        if( n == 1 ) return arr[st] ;
        if( n == 2 ) return Math.max( arr[st] , arr[st+1] ) ;
        int[] dp = new int[n] ;
        dp[0] = arr[st] ;
        dp[1] = Math.max( arr[st] , arr[st+1] ) ;
        for( int i = 2 ; i < n ; i++ ) {
            dp[i] = Math.max( dp[i-2] + arr[i+st] , dp[i-1] ) ;
        }
        return dp[n-1] ;
    }
    public int rob(int[] nums) {
        int n = nums.length ; 
        if( n == 0 ) return 0 ;
        if( n == 1 ) return nums[0] ;
        if( n == 2 ) return Math.max( nums[0] , nums[1] ) ; 
        return Math.max( maxDp( nums , 0 , nums.length - 2 ) , maxDp( nums , 1 , nums.length - 1 ) ) ;
    }
}