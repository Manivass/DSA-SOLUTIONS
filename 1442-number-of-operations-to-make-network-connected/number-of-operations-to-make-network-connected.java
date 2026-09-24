class Solution {
    public void dfs( int num , List<Integer>[] graph , boolean[] visited ) {
        if( visited[num] == true ) return ;
        visited[num] = true ;
        for( int neigh : graph[num] ) {
            if( visited[neigh] == true ) continue ;
            dfs( neigh , graph , visited ) ;
        }
    }
    public int makeConnected(int n, int[][] connections){ 
        List<Integer>[] graph = new List[n] ;
        for( int i = 0 ; i < n ; i++ ) graph[i] = new ArrayList<>() ;
        for( int[] num : connections ) {
            int u = num[0] ;
            int v = num[1] ;
            graph[u].add(v) ;
            graph[v].add(u) ;
        }
        if( connections.length < n - 1 ) return -1 ;
        boolean[] visited = new boolean[n] ;
        int compt = 0 ;
        for( int i = 0 ; i < n ; i++ ) {
            if( visited[i] == true  ) continue ;
            compt++ ;
            dfs( i , graph , visited ) ;
        }

        return compt - 1 ;
    }
}