class Solution {
    public int climbStairs(int n) {
        List<Integer> list = new ArrayList<>() ;
        if( n <= 2 ) return n ;
        list.add(1) ;
        list.add(2) ;
        for( int i = 3 ; i <= n ; i++ ) {
            list.add( list.get( i - 2 ) + list.get( i - 3 ) ) ;
        }
        return list.get(n-1) ;
    }
}