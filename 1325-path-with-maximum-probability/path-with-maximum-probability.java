class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<double[]>[] adjList = new List[n];
        for (int i = 0; i < n; i++)
            adjList[i] = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];
            adjList[u].add(new double[] { v, prob });
            adjList[v].add(new double[] { u, prob });
        }
        double[] dist = new double[n];
        Arrays.fill(dist, -1);
        dist[start_node] = 1;
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));
        pq.offer(new double[] { start_node, 1 });
        while (!pq.isEmpty()) {
            double[] curr = pq.poll();
            int edge = (int) curr[0];
            double weight = curr[1];
            if (weight < dist[edge])
                continue;
            for (double[] neigh : adjList[edge]) {
                int neighEdge = (int) neigh[0] ;
                double edgeProb = neigh[1] ;

                double newWeight = weight * edgeProb ;

                if (newWeight > dist[neighEdge]) {
                    dist[neighEdge] = newWeight;
                    pq.offer(new double[] { neighEdge, dist[neighEdge] });
                }
            }
        }
        return dist[end_node] == -1 ? 0 : dist[end_node];
    }
}