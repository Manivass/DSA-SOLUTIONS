class Solution {
    HashMap<String, Integer> dp = new HashMap<>();

    public int backtrack(int[][] arr, int i, int j) {
        if (j == arr[0].length - 1)
            return 0;
        int top_right = 0;

        int right = 0;

        int bottom_right = 0;

        String key = i + "-" + j;
        if (dp.containsKey(key))
            return dp.get(key);

        if (i > 0 && j < arr[0].length - 1 && arr[i][j] < arr[i - 1][j + 1]) {
            top_right = 1 + backtrack(arr, i - 1, j + 1);
        }

        if (j < arr[0].length - 1 && arr[i][j] < arr[i][j + 1]) {
            right = 1 + backtrack(arr, i, j + 1);
        }

        if (i < arr.length - 1 && j < arr[0].length - 1 && arr[i][j] < arr[i + 1][j + 1]) {
            bottom_right = 1 + backtrack(arr, i + 1, j + 1);
        }

        dp.put(key, Math.max(top_right, Math.max(right, bottom_right)));

        return Math.max(top_right, Math.max(right, bottom_right));
    }

    public int maxMoves(int[][] grid) {

        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            max = Math.max(max, backtrack(grid, i, 0));
        }
        return max;
    }
}