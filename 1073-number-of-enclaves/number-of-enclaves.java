class Solution {
    public void dfs(int[][] grid, int i, int j) {
        if (grid[i][j] == 0)
            return;
        grid[i][j] = 0;
        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };
        for (int k = 0; k < 4; k++) {
            int row = dr[k] + i;
            int col = dc[k] + j;
            if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length)
                continue;
            if (grid[row][col] == 0)
                continue;
            dfs(grid, row, col);
        }
    }

    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    if (grid[i][j] == 1)
                        dfs(grid, i, j);
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    cnt++;
            }
        }
        return cnt;
    }
}