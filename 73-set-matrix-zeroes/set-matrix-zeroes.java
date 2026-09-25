class Solution {
    public void setZeroes(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0)
                    q.offer(new int[] { i, j });
            }
        }

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];
            for (int j = 0; j < m; j++) {
                arr[j][col] = 0;
            }
            for (int j = 0; j < n; j++) {
                arr[row][j] = 0;
            }
        }
    }
}