class Solution {
    public int minLights(int[] arr) {
        int n = arr.length;
        int[] diff = new int[n + 1];

        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                int left = Math.max(0, i - arr[i]);
                int right = Math.min(n - 1, i + arr[i]);

                diff[left]++;
                diff[right + 1]--;
            }
        }

        int active = 0;
        int ans = 0;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            active += diff[i];

            if (active == 0) {
                cnt++;

                if (cnt == 3) {
                    ans++;
                    cnt = 0;
                }
            } else {
                if (cnt > 0) {
                    ans++;
                    cnt = 0;
                }
            }
        }

        if (cnt > 0) {
            ans++;
        }

        return ans;
    }
}