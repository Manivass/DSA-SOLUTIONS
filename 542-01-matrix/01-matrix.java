class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.offer(new int[] { i, j });
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int i = curr[0];
            int j = curr[1];
            int[] dr = { -1, 1, 0, 0 };
            int[] dc = { 0, 0, -1, 1 };
            for (int k = 0; k < 4; k++) {
                int row = dr[k] + i;
                int col = dc[k] + j;
                if (row < 0 || row >= m || col < 0 || col >= n || mat[row][col] != -1)
                    continue;
                mat[row][col] = mat[i][j] + 1;
                q.offer(new int[] { row, col });
            }
        }
        return mat;
    }
}