class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length ;
        boolean[] visited = new boolean[n] ;
        int minCost = 0 ;
        int edgesUsed = 0 ;
        PriorityQueue<int[]> pq = new PriorityQueue<>( ( a , b ) -> Integer.compare(a[1] , b[1]) ) ;
        pq.offer( new int[] { 0 , 0 } ) ;
        while( edgesUsed < n ) {
            int[] curr = pq.poll() ;
            int node = curr[0] ;
            int nodeDist = curr[1] ;
            if( visited[node] == true ) continue ;
            visited[node] = true ;
            minCost += nodeDist ;
            edgesUsed++ ;
             for (int nextNode = 0; nextNode < n; nextNode++) {
                if (!visited[nextNode]) {
                    int nextDist = Math.abs(points[node][0] - points[nextNode][0]) +
                                   Math.abs(points[node][1] - points[nextNode][1]);
                    pq.offer(new int[]{ nextNode, nextDist});
                }
            }
        }
        return minCost ;
    }
}