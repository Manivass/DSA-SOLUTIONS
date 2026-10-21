class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character , Integer> map = new HashMap<>() ;
        int i = 0;
        int j = 0 ;
        int max = 0 ;
        while( j < s.length() ) {
            char ch = s.charAt(j) ;
            if( map.containsKey(ch) && map.get(ch) >= i ) {
                i = map.get(ch) + 1 ;
            }
            map.put( ch , j ) ;
            max = Math.max( max , j - i + 1 ) ;
            j++ ;
        }
        return max ;
    }
}