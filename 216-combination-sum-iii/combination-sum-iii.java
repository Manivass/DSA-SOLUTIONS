class Solution {
    List<List<Integer>> ans = new ArrayList<>() ;
    public void backtrack( int index , int t , int k , List<Integer> list ) {
        if( t == 0 && list.size() == k ) {
            ans.add(new ArrayList<>(list)) ;
            return ;
        }
        if( t < 0 || list.size() >= k ) return ; 
        for( int i = index ; i <= 9 ; i++ ) {
            list.add(i) ;
            backtrack( i + 1 , t - i , k  , list ) ;
            list.remove( list.size() - 1 ) ;
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> list = new ArrayList<>() ;
        backtrack( 1 , n , k ,  list ) ;
        return ans ; 
    }
}