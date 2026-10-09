class Solution {
    int[] visited;

    public boolean dfs(int num, List<List<Integer>> graph) {
        if (visited[num] == 1)
            return false;
        if (visited[num] == 2)
            return true;
        visited[num] = 1;
        for (int neigh : graph.get(num)) {
            if (!dfs(neigh, graph))
                return false;
        }
        visited[num] = 2;
        return true;
    }

    public boolean canFinish(int n, int[][] pre) {
        visited = new int[n];
        List<List<Integer>> graph = new ArrayList<>();
        for( int i = 0 ; i < n ; i++ ) graph.add( new ArrayList<>() ) ;
        for (int[] num : pre) {
            graph.get(num[0]).add(num[1]);
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                if (!dfs(i, graph))
                    return false;
            }
        }
        return true;
    }
}