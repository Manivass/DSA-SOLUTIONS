class Solution {
    List<List<Integer>> ans = new ArrayList<>() ;
    public void backtrack( int st , int n , int[][] graph , List<Integer> list ) {
        if( st == n ) {
            ans.add( new ArrayList<>(list) ) ;
            return ;
        }
        for( int num : graph[st] ) {
            list.add( num ) ;
            backtrack( num , n , graph , list ) ;
            list.remove( list.size() - 1 ) ;
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> list = new ArrayList<>() ;
        int n = graph.length - 1 ;
        list.add(0) ;
        backtrack( 0 , n , graph , list ) ;
        return ans ;
    }
}