class Solution {
    public boolean dfs( int num , int[][] graph , int[] state ) {
        if( state[num] == 1 ) return false ;
        if( state[num] == 2 ) return true ;
        state[num] = 1 ;
        for( int neigh : graph[num] ) {
            if( !dfs( neigh , graph , state ) ) return false ;
        }
        state[num] = 2 ;
        return true ;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length ;
        List<Integer> list = new ArrayList<>() ;
        int[] state = new int[n] ;
        for( int i = 0 ; i < n ; i++ ) {
            if( dfs( i , graph, state ) ) {
                list.add(i) ;
            }
        }
        return list ;
    }
}