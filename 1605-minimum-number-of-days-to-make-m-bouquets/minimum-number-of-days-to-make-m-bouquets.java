class Solution {
    public int getBout(int[] arr, int k, int t) {
        int count = 0;
        int adj = 0;
        for (int num : arr) {
            if (num <= t) {
                adj++;
            } else {
                count += (int) Math.floor(adj / k);
                adj = 0;
            }
        }
        count += (adj / k);
        return count;
    }

    public int minDays(int[] arr, int m, int k) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int num : arr) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        int l = min;
        int r = max;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int boutque = getBout(arr, k, mid);
            if (boutque >= m) {
                r = mid;
            } else
                l = mid + 1;
        }
        if ((long) m * k > arr.length)
            return -1;
        else return r ; 
    }
}