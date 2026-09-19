class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++)
            Arrays.fill(dist[i], Integer.MAX_VALUE);

        Queue<int[]> q = new ArrayDeque<>();
        dist[entrance[0]][entrance[1]] = 0;
        q.offer(entrance);

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int[] dr = { -1, 1, 0, 0 };
            int[] dc = { 0, 0, -1, 1 };
            for (int i = 0; i < 4; i++) {
                int row = dr[i] + curr[0];
                int col = dc[i] + curr[1];
                if (row < 0 || row >= m || col < 0 || col >= n)
                    continue;
                if (maze[row][col] != '.')
                    continue;
                if (dist[row][col] == Integer.MAX_VALUE) {
                    dist[row][col] = dist[curr[0]][curr[1]] + 1;
                    q.offer(new int[] { row, col });
                }
            }
        }
        int min = Integer.MAX_VALUE ;
        for( int i = 0 ; i < m ; i++ ) {
            for( int j = 0 ; j < n ; j++ ) {
                if( i == entrance[0] && j == entrance[1] ) continue ;
                if( i != 0 && j!= 0 && i != m-1 && j != n-1) continue ;
                min = Math.min( min , dist[i][j] ) ;
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min ;
    }
}