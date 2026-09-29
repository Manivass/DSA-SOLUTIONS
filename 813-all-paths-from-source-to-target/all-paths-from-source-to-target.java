class Solution {
    HashSet<Integer> visited = new HashSet<>();
    List<List<Integer>> ans = new ArrayList<>();

    public void dfs(int st, int end, int[][] graph , List<Integer> list ) {
        if (st == end) {
            ans.add(new ArrayList<>(list));
        }
        for (int neigh : graph[st]) {
            if (!visited.contains(neigh)) {
                visited.add(neigh);
                list.add(neigh);
                dfs(neigh, end, graph , list );
                list.remove(list.size() - 1);
                visited.remove(neigh);
            }
        }
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        visited.add(0);
        list.add(0) ;
        dfs(0, graph.length - 1, graph , list);
        return ans;
    }
}