class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if( grid[0][0] == 1 || grid[m-1][n-1] == 1) return -1 ;
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++)
            Arrays.fill(dist[i], -1);
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] { 0, 0 });
        dist[0][0] = 1 ;
        while (!q.isEmpty()) {
            int[] curr = q.poll() ;
            int row = curr[0];
            int col = curr[1];
            int[] dr = { -1, -1, 0, -1, 1, 1, 0, 1 };
            int[] dc = { 0, -1, -1, 1, 0, 1, 1, -1 };
            for (int i = 0; i < 8; i++) {
                int newRow = dr[i] + row;
                int newCol = dc[i] + col;
                if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n)
                    continue;
                if (grid[newRow][newCol] != 0 || dist[newRow][newCol] != -1)
                    continue;
                dist[newRow][newCol] = dist[row][col] + 1;
                q.offer(new int[] { newRow, newCol });
            }
        }
        return dist[m-1][n-1] ;
    }
}