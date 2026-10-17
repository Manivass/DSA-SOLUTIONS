class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder() ;
        HashSet<Integer> set = new HashSet<>() ;
        for( int num : spaces ) set.add(num) ;
        for( int i = 0 ; i < s.length() ; i++ ) {
            if( set.contains( i ) ) {
                sb.append(" ") ;
                set.remove(i) ;
                i-- ;
            }
            else sb.append(s.charAt(i)) ;
        }
        return sb.toString() ;
    }
}