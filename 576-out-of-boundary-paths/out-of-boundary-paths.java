class Solution {
    HashMap<String, Integer> dp = new HashMap<>();
    int MOD = 1000000007;

    public int backtrack(int i, int j, int m, int n, int maxMove) {
        if (i < 0 || i == m || j < 0 || j == n)
            return 1;
        if (maxMove <= 0)
            return 0;

        String key = i + "-" + j + "-" + maxMove;
        if (dp.containsKey(key))
            return dp.get(key);

        int top = backtrack(i - 1, j, m, n, maxMove - 1);
        int left = backtrack(i, j - 1, m, n, maxMove - 1);
        int bottom = backtrack(i + 1, j, m, n, maxMove - 1);
        int right = backtrack(i, j + 1, m, n, maxMove - 1);
        long ans = ((long) top + left + bottom + right) % MOD;

        dp.put(key, (int) ans);
        return (int) ans;

    }

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {

        return backtrack(startRow, startColumn, m, n, maxMove);
    }
}