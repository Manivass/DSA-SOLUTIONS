class Solution {

    int[][][] dp ;

    public int backtrack(int[][] arr, int st, int m, int n) {

        if (m < 0 || n < 0)
            return Integer.MIN_VALUE;

        if (st >= arr.length)
            return 0;

        if( dp[st][m][n] != - 1 ) return dp[st][m][n] ;
        
        int max = 0;

        for (int i = st; i < arr.length; i++) {

            int result = backtrack(
                arr,
                i + 1,
                m - arr[i][0],
                n - arr[i][1]
            );

            if (result != Integer.MIN_VALUE) {
                max = Math.max(max, 1 + result);
            }
        }

        dp[st][m][n] = max ;
        return dp[st][m][n];
    }

    public int findMaxForm(String[] strs, int m, int n) {

        dp = new int[strs.length][m + 1][n+1] ;
        for( int i = 0 ; i < strs.length ; i++ ) {
            for( int j = 0 ; j <= m ; j++ ) {
                for( int k = 0 ; k <= n ; k++ ) {
                    dp[i][j][k] = -1 ;
                }
            }
        }

        int[][] zo = new int[strs.length][2];

        for (int i = 0; i < strs.length; i++) {

            for (int j = 0; j < strs[i].length(); j++) {

                if (strs[i].charAt(j) == '0')
                    zo[i][0]++;
                else
                    zo[i][1]++;
            }
        }

        return backtrack(zo, 0 , m, n);
    }
}