class Solution {
    public boolean dfs( int num , List<List<Integer>> graph , int[] visited ) {
        if( visited[num] == 1 ) return false ;
        if( visited[num] == 2 ) return true ;
        visited[num] = 1 ;
        for( int neigh : graph.get(num) ) {
            if( !dfs( neigh , graph , visited ) ) return false ;
        }
        visited[num] = 2 ;
        return true ;
    }
    public boolean canFinish(int n, int[][] pre ) {
        List<List<Integer>> graph = new ArrayList<>() ;
        for( int i = 0 ; i < n ; i++ ) graph.add( new ArrayList<>() ) ;
        for( int[] num : pre ) {
            graph.get(num[0]).add(num[1]) ;
        }
        int[] visited = new int[n] ;
        Arrays.fill(visited , -1) ;
        for( int i = 0 ; i < n ; i++ ) {
            if( visited[i] == -1 ) {
               if(!dfs( i , graph , visited )) return false ;
            }
        }
        return true ;
    }
}