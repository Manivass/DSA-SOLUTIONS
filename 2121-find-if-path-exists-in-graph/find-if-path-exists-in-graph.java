class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<Integer>[] graph = new ArrayList[n] ;
        for( int i = 0 ; i < n ; i++ ) graph[i] = new ArrayList<>() ;
        for( int[] edge : edges ) {
            int a = edge[0] ;
            int b = edge[1] ;
            graph[a].add(b) ;
            graph[b].add(a) ;
        }
        Queue<Integer> q = new LinkedList<>() ;
        q.offer( source ) ;
        HashSet<Integer> visited = new HashSet<>() ;
        visited.add(source) ;

        while( !q.isEmpty() ) {
            int curr = q.poll() ;
            if( curr == destination ) return true ;
            for( int num : graph[curr] ) {
                if( !visited.contains( num ) ) {
                    q.offer(num) ;
                    visited.add( num ) ;
                }
            }
        }
        return false  ; 
    }
}