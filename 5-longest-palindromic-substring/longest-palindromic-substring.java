class Solution {
    public String longestPalindrome(String s) {
        int st = 0 ;
        int end  = 0 ;
        int size = 0 ;
        int n = s.length() ;
        boolean[][] dp = new boolean[n][n] ;
        for( int i = 0 ; i < n ; i++ ) {
            dp[i][i] = true ;
            if( i < n - 1 && s.charAt(i) == s.charAt(i+1) ) {
                dp[i][i+1] = true ;
                if( size < 2 ) {
                    size = 2 ;
                    st = i ;
                    end = i + 1 ;
                }
            }
        }
        for( int i = 3 ; i <= n ; i++ ) {
            for( int j = 0 ; j <= n - i ; j++ ) {
                int k = i + j - 1 ;
                if( s.charAt(j) == s.charAt(k) && dp[j+1][k-1] == true ) {
                    dp[j][k] = true ;
                    if( size < k -j + 1) {
                        size = k - j + 1 ;
                        st = j ;
                        end = k ;
                    }
                }
            }
        }
        return s.substring(st , end + 1) ; 
    }
}