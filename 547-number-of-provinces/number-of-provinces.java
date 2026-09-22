class Solution {
    public void dfs(List<Integer>[] adjList, int[] visited, int num) {
        visited[num] = 1;
        for (int neigh : adjList[num]) {
            if( visited[neigh] == 0 )
                dfs(adjList, visited, neigh);
        }
    }

    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;
        List<Integer>[] adjList = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();

            for (int j = 0; j < n; j++) {

                if (i == j)
                    continue;

                if (isConnected[i][j] == 1) {
                    adjList[i].add(j);
                }
            }
        }

        int[] visited = new int[n] ;
        int count = 0 ;
        for (List<Integer> num : adjList)
            System.out.println(num);
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                count++ ;
                dfs(adjList, visited, i);
            }
        }
        return count ;
    }
}