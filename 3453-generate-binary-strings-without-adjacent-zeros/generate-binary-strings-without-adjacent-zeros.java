class Solution {
    List<String> str = new ArrayList<>() ;
    public void backtrack( List<Integer> list , int n ) {
        if( list.size() == n ) {
            StringBuilder sb = new StringBuilder() ;
            for( int num : list ) {
                sb.append(num) ;
            }
            str.add( sb.toString() ) ;
            return ;
        }
        int last = list.get( list.size() - 1 ) ;
        if( last == 0 ) {
            list.add(1) ;
            backtrack( list , n ) ;
            list.remove(list.size() - 1) ;
        }
        else {
            list.add(0) ;
            backtrack( list , n ) ;
            list.remove(list.size() - 1) ;
            list.add(1) ;
            backtrack( list , n ) ;
            list.remove(list.size() - 1) ;
        }
    }
    public List<String> validStrings(int n) {
        List< Integer > list = new ArrayList<>() ;
        list.add(0) ;
        backtrack( list , n ) ;
        list.remove(list.size() - 1) ;
        list.add(1) ;
        backtrack( list , n ) ;
        return str ;
    }
}