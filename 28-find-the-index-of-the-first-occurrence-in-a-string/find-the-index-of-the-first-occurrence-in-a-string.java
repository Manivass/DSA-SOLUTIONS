class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        int[] lps = new int[n];
        int i = 0;
        int j = 1;
        while (j < n) {
            char str1 = needle.charAt(i);
            char str2 = needle.charAt(j);
            if (str1 == str2) {
                lps[j] = i + 1;
                i++;
                j++;
            } else {
                if (i == 0) {
                    lps[j] = 0;
                    j++;
                } else
                i = lps[i - 1];
            }
        }
        System.out.println(Arrays.toString(lps)) ;
        i = 0 ;
        j = 0 ;
        while(i < m && j < n ) {
            char ch1 = haystack.charAt(i) ;
            char ch2 = needle.charAt(j) ;
            if( ch1 == ch2 ) {
                i++ ;
                j++ ;
                if( j == n ) return i - n  ;
            }
            else {
                if( j == 0 ) i++ ;
                else j = lps[j-1] ;
            }
        }
        return -1 ;
    }
}