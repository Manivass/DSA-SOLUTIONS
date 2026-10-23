class Solution {
    public String minWindow(String s, String t) {
        if( t.length() > s.length() ) return "" ;
        int left = 0;
        int right = 0;
        int start = 0 ;
        int min = Integer.MAX_VALUE ;
        HashMap<Character , Integer> map = new HashMap<>() ;
        HashMap<Character , Integer> window = new HashMap<>() ;
        for( char ch : t.toCharArray() ) map.put( ch , map.getOrDefault(ch,0) + 1 ) ;
        int formed = 0;
        int required = map.size() ;
        String str = "" ;
        for( right = 0 ; right < s.length() ; right++ ) {
            char ch = s.charAt(right) ;
            window.put( ch , window.getOrDefault( ch , 0 ) + 1 ) ;
            if( map.containsKey(ch) && map.get( ch ).intValue() == window.get(ch).intValue() ) formed++ ;
            while( formed == required ) {
                int size = right - left + 1 ;
                if( size < min ) {
                    min = size ;
                    start = left ;
                }
                char charLeft = s.charAt(left) ;
                window.put( charLeft , window.get(charLeft) - 1 ) ;
                if( map.containsKey( charLeft ) && window.get(charLeft) < map.get(charLeft) )   formed-- ;
                left++ ;
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring( start , start + min ) ;
    }
}