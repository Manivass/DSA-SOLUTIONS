class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<List<Integer>>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        for (int[] num : times) {
            List<Integer> list = new ArrayList<>();
            list.add(num[1]);
            list.add(num[2]);
            graph.get(num[0] - 1).add(list);
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k - 1] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[] { k - 1, 0 });
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int val = curr[0];
            int weight = curr[1];
            if (dist[val] < weight)
                continue;
            for (List<Integer> neigh : graph.get(val)) {
                int next = neigh.get(0) - 1;
                int edgeWeight = neigh.get(1);

                int newDist = weight + edgeWeight;

                if (newDist < dist[next]) {

                    dist[next] = newDist;

                    pq.offer(
                            new int[] { next, newDist });
                }
            }
        }
        int ans = 0;

        for (int d : dist) {

            if (d == Integer.MAX_VALUE)
                return -1;

            ans = Math.max(ans, d);
        }

        return ans;
    }
}