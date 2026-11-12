class Solution {
    public int fib(int n) {
        List<Integer> list = new ArrayList<>() ;
        list.add(0) ;
        list.add(1) ;
        for( int i = 2 ; i <= n ; i++ ) {
            list.add( list.get( list.size() - 1 ) + list.get( list.size() - 2 ) ) ;
        }
        return list.get( n ) ;
    }
}