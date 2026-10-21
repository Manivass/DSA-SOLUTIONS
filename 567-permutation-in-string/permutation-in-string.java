class Solution {
    public boolean permute( int[] arr1 , int[] arr2 ) {
        for( int i = 0 ; i < 26 ; i++ ) {
            if( arr1[i] != arr2[i] ) return false ;
        }
        return true ;
    }
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        if( m > n ) return false ;
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        int i = 0;
        int j = 0;
        for (i = 0; i < s1.length(); i++) {
            arr1[s1.charAt(i) - 'a']++;
            arr2[s2.charAt(i) - 'a']++;
        }
        i = 0 ;
        j = s1.length() - 1;
        while (j < s2.length()) {
            if (permute(arr1, arr2))
                return true;
            else {
                char ch = s2.charAt(i);
                arr2[ch - 'a']--;
                i++;
                j++;
                if( j  < s2.length()  ) {
                ch = s2.charAt(j);
                arr2[ch - 'a']++;
                }
            }
        }
        return false ;
    }
}