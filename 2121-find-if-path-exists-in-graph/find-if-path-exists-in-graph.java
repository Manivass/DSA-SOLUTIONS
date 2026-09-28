class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph = new ArrayList<>() ;
        for( int i = 0 ; i < n ; i++ ) graph.add( new ArrayList<>() ) ;
        for( int[] num : edges ) {
            int u = num[0] ;
            int v = num[1] ;
            graph.get(u).add(v) ;
            graph.get(v).add(u) ;
        }
        Queue<Integer> queue = new ArrayDeque<>() ;
        HashSet<Integer> visited = new HashSet<>() ;
        visited.add(source) ;
        queue.offer( source ) ;
        while( !queue.isEmpty() ) {
            int curr = queue.poll() ;
            if( curr == destination ) return true ;
            for( int neigh : graph.get(curr) ) {
                if( !visited.contains(neigh) ) {
                    visited.add(neigh) ;
                    queue.offer(neigh) ;
                }
            }
        }
        return false ;
    }
}