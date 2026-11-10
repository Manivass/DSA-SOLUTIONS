class Solution {
    List<List<String>> ans = new ArrayList<>() ;
    public boolean palindrome( String str ) {
        int left = 0 ;
        int right = str.length() - 1 ;
        while( left < right ) {
            if( str.charAt(left) != str.charAt(right) ) return false ;
            left++ ;
            right -- ;
        }
        return true ;
    }
    public void backtrack( String str , List<String> list ) {
        if( str.length() == 0 ) {
            ans.add( new ArrayList<>(list) ) ;
            return ;
        }
        for( int i = 1 ; i <= str.length() ; i++ ) {
            String sub = str.substring(0,i) ;
            boolean isPalindrome = palindrome( sub ) ;
            if( !isPalindrome ) continue ;
            list.add(sub) ;
            backtrack( str.substring( i , str.length() ) , list ) ;
            list.remove( list.size() - 1 ) ; 
        }
    }
    public List<List<String>> partition(String s) {
        List<String> list = new ArrayList<>() ;
        backtrack( s ,  list) ;
        return ans ; 
    }
}