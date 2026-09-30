class Solution {
    int[][] dp;

    public int backtrack(String word1, String word2, int i, int j) {
        if (i < 0)
            return j + 1;
        if (j < 0)
            return i + 1;
        
        if( dp[i][j] != -1 ) return dp[i][j] ;

        if (word1.charAt(i) == word2.charAt(j)) {
            return backtrack(word1, word2, i - 1, j - 1);
        }
        int deleteFirst = backtrack(word1, word2, i - 1, j);
        int deleteSecond = backtrack(word1, word2, i, j - 1);
        dp[i][j] = 1 + Math.min(deleteFirst, deleteSecond);
        return dp[i][j] ;
    }

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        dp = new int[m][n];
        for( int i = 0 ; i < m ; i++ ) Arrays.fill( dp[i] , -1 ) ;
        return backtrack(word1, word2, word1.length() - 1, word2.length() - 1);
    }
}