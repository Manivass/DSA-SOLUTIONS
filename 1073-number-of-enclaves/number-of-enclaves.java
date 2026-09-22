class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                    if (grid[i][j] == 1) {
                        q.offer(new int[] { i, j });
                        visited[i][j] = true;
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int[] dr = { -1, 1, 0, 0 };
            int[] dc = { 0, 0, -1, 1 };
            for (int i = 0; i < 4; i++) {
                int row = dr[i] + curr[0];
                int col = dc[i] + curr[1];
                if (row < 0 || row >= m || col < 0 || col >= n)
                    continue;
                if (visited[row][col] == true)
                    continue;
                if (grid[row][col] == 1) {
                    q.offer(new int[] { row, col });
                    visited[row][col] = true;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && visited[i][j] == false)
                    count++;
            }
        }
        return count;
    }
}