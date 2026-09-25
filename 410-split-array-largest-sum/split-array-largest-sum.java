class Solution {
    int[] prefixSum;
    int[] suffixSum;

    int[][] dp ;

    public int backtrack(int i, int[] arr, int k, int split) {
        if (i >= arr.length)
            return Integer.MAX_VALUE;
        if (split > k)
            return Integer.MAX_VALUE;
        if (k == split + 1 && i + 1 <= arr.length)
            return suffixSum[i];
        if( dp[i][split] != -1 ) return dp[i][split] ;
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int j = i; j < arr.length; j++) {
            int res = backtrack(j + 1, arr, k, split + 1);

            if (res != Integer.MAX_VALUE) {
                // int currentSum;

                // if (i == 0)
                //     currentSum = prefixSum[j];
                // else
                //     currentSum = prefixSum[j] - prefixSum[i - 1];
                max = Math.max(prefixSum[j] - prefixSum[i - 1], res);
                min = Math.min(min, max);

            }
        }
        dp[i][split] = min ;
        return min;
    }

    public int splitArray(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int n = nums.length;
        prefixSum = new int[n];
        suffixSum = new int[n];
        prefixSum[0] = nums[0];
        suffixSum[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++)
            prefixSum[i] = nums[i] + prefixSum[i - 1];
        for (int i = n - 2; i >= 0; i--)
            suffixSum[i] = nums[i] + suffixSum[i + 1];
        if( k == 1 ) return prefixSum[n-1] ;
        dp = new int[n][k+1] ;
        for( int i = 0 ; i < n ; i++ ) Arrays.fill( dp[i] , -1 ) ;  
        int max = 0;
        for (int i = 0; i <= n - k; i++) {
            max = 0;
            max = Math.max(prefixSum[i], backtrack(i + 1, nums, k, 1));
            min = Math.min(min, max);
        }
        return min;
    }
}