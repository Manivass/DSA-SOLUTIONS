class Solution {
    public int countPaths(int n, int[][] roads) {
        int m = roads.length ;
        List<List<List<Integer>>> graph = new ArrayList<>() ;
        for( int i = 0 ; i < n ; i++ ) graph.add(new ArrayList<>()) ;
        for( int[] num : roads ) {
            int u = num[0] ;
            int v = num[1] ;
            int dist = num[2] ;
            List<Integer> list1 = Arrays.asList( v , dist ) ;
            List<Integer> list2 = Arrays.asList( u , dist ) ;
            graph.get(u).add(list1) ;
            graph.get(v).add(list2) ;
        }
        PriorityQueue<long[]> pq = new PriorityQueue<>(( a , b ) -> Long.compare( a[1] , b[1] )) ;
        pq.offer( new long[] { 0 , 0 } ) ;
        long[] dist = new long[n] ;
        long[] ways = new long[n] ;
        Arrays.fill( dist , Long.MAX_VALUE );
        dist[0] = 0 ;
        ways[0] = 1 ;
        long MOD = 1000000007 ;
        while( !pq.isEmpty() ) {
            long[] curr = pq.poll() ;
            int edge = (int)curr[0] ;
            long eDist = curr[1] ;
            for( List<Integer> num : graph.get(edge) ) {
                int u = (int)num.get(0) ;
                long newDist = num.get(1) + eDist ;
                if( newDist < dist[u] ) {
                    dist[u] = newDist ;
                    ways[u] = ways[edge] ;
                    pq.offer( new long[] { u , dist[u] } ) ;
                }
                else if( newDist == dist[u] ) {
                    ways[u] = ( ways[u] + ways[edge] ) % MOD ;
                }
            }
        }
        return (int) ways[n-1] ;
    }
}