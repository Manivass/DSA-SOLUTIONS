class Solution {
    int min = Integer.MAX_VALUE ;
    public boolean powerOfFive(String s) {
        long dec = Long.parseLong(s, 2);
        if (dec == 0) return false;
        while( dec % 5 == 0 ) {
            dec = dec / 5 ; 
        }
        return dec == 1 ; 
    }

    public void backtrack(String str, List<String> list) {
        String last = list.get(list.size() - 1);
        boolean isPow = powerOfFive(last);
        if( str.length() == 0 && isPow ) min = Math.min( min , list.size() ) ;
        if( str.length() == 0 ) return ;
        if( isPow && str.charAt(0) != '0' ) {
            list.add(str.charAt(0) + "") ;
            backtrack( str.substring( 1 , str.length() ) , list ) ;
            list.remove(list.size() - 1) ; 
        }
        last = last + str.charAt(0) ;
        list.set( list.size() - 1 , last ) ;
        backtrack( str.substring( 1 , str.length() ) , list ) ;
        list.set(list.size() - 1, last);
    }

    public int minimumBeautifulSubstrings(String s) {
        if (s.charAt(0) == '0')
            return -1;
        String sub = s.substring(0, 1);
        List<String> list = new ArrayList<>();
        list.add(sub);
        backtrack(s.substring(1, s.length()), list);
        return min == Integer.MAX_VALUE ? -1 : min ;
    }
}