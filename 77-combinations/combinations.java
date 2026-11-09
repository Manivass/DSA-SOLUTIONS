class Solution {
    List< List<Integer> > ans = new ArrayList<>() ;
    public void backtrack( int index , int n , int k , List< Integer > list ) {
        if( list.size() == k ) {
            ans.add( new ArrayList<>(list) ) ;
            return ;
        }
        if( index > n ) return ;
        for( int i = index ; i <= n ; i++ ) {
            list.add( i ) ;
            backtrack( i + 1 , n , k , list ) ;
            list.remove( list.size() - 1 ) ;
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> list = new ArrayList<>() ;
        backtrack( 1 , n , k , list ) ;
        return ans ; 
    }
}