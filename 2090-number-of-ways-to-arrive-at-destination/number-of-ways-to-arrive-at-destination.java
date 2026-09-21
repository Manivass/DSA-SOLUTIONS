class Solution {
    public int countPaths(int n, int[][] grid) {
        int last = n - 1;
        long min = Long.MAX_VALUE;
        List<List<List<Integer>>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        for (int[] arr : grid) {
            int u = arr[0];
            int v = arr[1];
            int dist = arr[2];
            List<Integer> list1 = Arrays.asList(v, dist);
            List<Integer> list2 = Arrays.asList(u, dist);
            graph.get(u).add(list1);
            graph.get(v).add(list2);
        }
        long MOD = 1_000_000_007;
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        long[] dist = new long[n];
        long[] ways = new long[n] ;
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;
        pq.offer(new long[] { 0, 0 });
        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            int edge = (int)curr[0];
            long eDist = curr[1];
            if (dist[edge] < eDist)
                continue;
            for (List<Integer> num : graph.get(edge)) {
                int neigh = num.get(0);
                int neighDist = num.get(1);
                long newDist = eDist + neighDist;
                if (newDist < dist[neigh]) {
                    dist[neigh] = newDist;
                    ways[neigh] = ways[edge];
                    pq.offer(new long[] { neigh, dist[neigh] });
                }
                else if( newDist == dist[neigh] ) {
                    ways[neigh] = (ways[neigh] + ways[edge])%MOD ;
                }
            }
        }
        return (int)ways[n-1];
    }

}