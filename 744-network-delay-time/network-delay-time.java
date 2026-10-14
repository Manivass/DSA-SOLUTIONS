class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<List<Integer>>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int dist = time[2];
            List<Integer> list = Arrays.asList(v, dist);
            graph.get(u - 1).add(list);
        }
        int[] dist = new int[n];
        Arrays.fill(dist , Integer.MAX_VALUE) ;
        dist[k - 1] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.offer( new int[] { k  , 0  } ) ;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int edge = curr[0] - 1 ;
            int eDist = curr[1] ;
            for( List<Integer> neigh : graph.get(edge) ) {
                int neighEdge = neigh.get(0) ;
                int neighDist = neigh.get(1) ;
                int newDist = eDist + neighDist ;
                if( newDist < dist[neighEdge - 1] ) {
                    dist[neighEdge - 1] = newDist ;
                    pq.offer( new int[] { neighEdge , newDist } ) ;
                }
            }
        }
        int max = 0 ;
        for( int d : dist ) {
            if( d == Integer.MAX_VALUE ) return -1 ;
            max = Math.max(max , d) ;
        }
        return max ;


    }
}