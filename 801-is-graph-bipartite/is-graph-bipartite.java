class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length ;
        int[] color = new int[n] ;
        Arrays.fill( color , -1 ) ;
        Queue<Integer> q = new ArrayDeque<>() ;
        for(int i = 0 ; i < n ; i++ ) {
            if( color[i] != -1  ) continue ;
            color[i] = 1 ;
            q.offer(i) ;
            while( !q.isEmpty() ) {
                int curr = q.poll() ;
                int n_col ;
                if( color[curr] == 1 ) n_col = 2 ;
                else n_col = 1 ;
                for( int neigh : graph[curr] ) {
                    if( color[neigh] == -1 ) {
                        color[neigh] = n_col ;
                        q.offer( neigh ) ;
                    }
                    else if( n_col != color[neigh] ) {
                        return false ;
                    }
                }
            }
        }
        return true ;
    }
}