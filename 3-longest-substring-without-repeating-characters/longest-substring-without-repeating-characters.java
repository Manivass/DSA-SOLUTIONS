class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0 ;
        int j = 0 ;
        int max = 0 ;
        HashMap<Character , Integer> map = new HashMap<>() ;
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