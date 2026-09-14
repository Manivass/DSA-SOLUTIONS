class Solution {
    HashMap<String, Integer> dp = new HashMap<>();

    public int backtrack(int[] arr, int st, int last, int diff) {
        if (st >= arr.length)
            return 0;
        int ans = 0;
        int sign = diff > 0 ? 1 : -1;
        String key = st + "-" + last + "-" + sign;
        if (dp.containsKey(key))
            return dp.get(key);

        for (int i = st; i < arr.length; i++) {
            int currDiff = arr[i] - arr[last];
            if ((diff > 0 && currDiff < 0) ||
                    (diff < 0 && currDiff > 0)) {

                ans = Math.max(
                        ans,
                        1 + backtrack(
                                arr,
                                i + 1,
                                i,
                                currDiff));
            }
        }
        dp.put(key, ans);
        return ans;
    }

    public int wiggleMaxLength(int[] arr) {
        int ans = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] - arr[i] == 0)
                    continue;
                ans = Math.max(ans, 2 + backtrack(arr, j + 1, j, arr[j] - arr[i]));
            }
        }
        return ans;
    }
}