class Solution {
    public int[][] highestPeak(int[][] arr) {
        int m = arr.length ;
        int n = arr[0].length;

        int[][] dist = new int[m][n];
        Queue<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < m; i++)
            Arrays.fill(dist[i], -1);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    dist[i][j] = 0;
                    q.offer(new int[] { i, j });
                }
            }
        }

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int frst = curr[0];
            int second = curr[1];
            int[] dr = { -1, 1, 0, 0 };
            int[] dc = { 0, 0, -1, 1 };
            for (int i = 0; i < 4; i++) {
                int row = dr[i] + curr[0];
                int col = dc[i] + curr[1];
                if (row < 0 || row >= m || col < 0 || col >= n)
                    continue;

                if (dist[row][col] == -1) {
                    dist[row][col] = dist[frst][second] + 1;
                    q.offer(new int[] { row, col });
                }
            }
        }

        return dist;

    }
}