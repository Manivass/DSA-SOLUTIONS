class Solution {
    public int swimInWater(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        pq.offer(new int[] { 0, 0,  grid[0][0] });
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int r = curr[0];
            int c = curr[1];
            if (visited[r][c])
                continue;
            int max = curr[2] ;
            if( r == m - 1 && c == n - 1 ) return max ;
            visited[r][c] = true;
            int[] dr = { -1, 1, 0, 0 };
            int[] dc = { 0, 0, -1, 1 };
            for (int i = 0; i < 4; i++) {
                int row = dr[i] + r;
                int col = dc[i] + c;
                if (row < 0 || row >= m || col < 0 || col >= n)
                    continue;
                if (visited[row][col])
                    continue;
                int newMax = Math.max(max, grid[row][col]);
                pq.offer( new int[] { row , col , newMax } ) ;
            }
        }
        return 0 ;
    }
}