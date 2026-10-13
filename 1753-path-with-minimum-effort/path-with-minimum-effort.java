class Solution {
    public int minimumEffortPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dist = new int[m][n];
        for (int[] arr : dist)
            Arrays.fill(arr, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        pq.offer(new int[] { 0, 0, 0 });
        dist[0][0] = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int row = curr[0];
            int col = curr[1];
            int weight = curr[2];
            int[] dr = { -1, 1, 0, 0 };
            int[] dc = { 0, 0, -1, 1 };
            for (int i = 0; i < 4; i++) {
                int newRow = dr[i] + row;
                int newCol = dc[i] + col;
                if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n)
                    continue;
                int newDist = Math.max( weight , Math.abs(grid[row][col] - grid[newRow][newCol]));
                if (newDist < dist[newRow][newCol]) {
                    dist[newRow][newCol] = newDist;
                    pq.offer(new int[] { newRow, newCol, newDist });
                }
            }
        }
        return dist[m-1][n-1] == Integer.MAX_VALUE ? -1 : dist[m-1][n-1] ;

    }
}