class Solution {
        

        public void backtrack( List<String> list , int index , String digits , StringBuilder sb , HashMap<Integer , String > map  ) {
            if( index == digits.length() && digits.length() == sb.length() ) {
                list.add( sb.toString() ) ;
                return ;
            }
            String numStr = map.get(digits.charAt(index) - '0') ;
            for( char ch : numStr.toCharArray() ) {
                sb.append(ch) ;
                backtrack(list , index + 1 , digits , sb, map ) ;
                sb.delete( sb.length() - 1 , sb.length() ) ;
            }
        }
        public List<String> letterCombinations(String digits) {
            
            List<String> list = new ArrayList<>() ;
            HashMap<Integer , String> map = new HashMap<>() ;
            map.put( 2 , "abc" ); 
            map.put( 3 , "def" ); 
            map.put( 4, "ghi" ); 
            map.put( 5 , "jkl" ); 
            map.put( 6 , "mno" ); 
            map.put( 7 , "pqrs" ); 
            map.put( 8 , "tuv" ); 
            map.put( 9 , "wxyz" );
            backtrack( list , 0 , digits , new StringBuilder() , map) ;
            return list ; 
        }
}