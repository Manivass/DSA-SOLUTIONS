class Solution {
    public int swimInWater(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        pq.offer(new int[] { 0, 0, 0 });
        visited[0][0] = true;
        int max = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];
            int v = curr[1];

            max = Math.max(max, grid[u][v]);
            if (u == m - 1 && v == n - 1)
                return max;
            int dist = curr[2];
            int[] dr = { -1, 1, 0, 0 };
            int[] dc = { 0, 0, -1, 1 };
            for (int i = 0; i < 4; i++) {
                int row = dr[i] + u;
                int col = dc[i] + v;
                if (row < 0 || row >= m || col < 0 || col >= n)
                    continue;
                if (visited[row][col])
                    continue;
                visited[row][col] = true;
                pq.offer(new int[] { row, col, grid[row][col] });
            }
        }
        return -1;
    }
}