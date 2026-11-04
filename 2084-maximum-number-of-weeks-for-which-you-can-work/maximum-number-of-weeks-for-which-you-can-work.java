
class Solution {
    public long numberOfWeeks(int[] milestones) {

        long sum = 0;
        long max = 0;

        for (int val : milestones) {
            sum += val;
            max = Math.max(max, val);
        }

        long remaining = sum - max;

        if (max <= remaining + 1) {
            return sum;
        }

        return 2 * remaining + 1;
    }
}
