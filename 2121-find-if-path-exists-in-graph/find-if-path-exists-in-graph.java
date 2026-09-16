class Solution {
    HashSet<Integer> visited = new HashSet<>();

    public boolean isSourceExist(int curr, int t, List<Integer>[] graph) {
        if (curr == t)
            return true;
        visited.add(curr);
        for (int num : graph[curr]) {
            if (!visited.contains(num)) {
                if (isSourceExist(num, t, graph)) {
                    return true;
                }
            }

        }
        return false;
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();
        for (int[] edge : edges) {
            int x1 = edge[0];
            int x2 = edge[1];
            graph[x1].add(x2);
            graph[x2].add(x1);
        }
        return isSourceExist(source, destination, graph);
    }
}