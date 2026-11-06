class Solution {
    public String reverseWords(String s) {
        String[] str = s.split(" ");
        HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int vowelCount = 0 ;
        for( char ch : str[0].toCharArray() ) {
            if( vowels.contains(ch) ) vowelCount++ ;
        }
        for( int i = 1 ; i < str.length ; i++ ) {
            int cnt = 0 ;
            for( char ch : str[i].toCharArray() ) {
                if( vowels.contains(ch) ) cnt++ ;
            }
            if( cnt == vowelCount ) {
                StringBuilder sb = new StringBuilder( str[i] ) ;
                sb.reverse() ;
                str[i] = sb.toString() ;
            }
        }
        return String.join(" ",str) ; 
    }
}