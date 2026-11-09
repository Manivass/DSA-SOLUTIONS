class Solution {
    public int longestSubarray(int[] nums) {

        int max = 0;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        int cnt = 0;
        int ans = 0;

        for (int num : nums) {

            if (num == max) {
                cnt++;
                ans = Math.max(ans, cnt);
            } else {
                cnt = 0;
            }
        }

        return ans;
    }
}