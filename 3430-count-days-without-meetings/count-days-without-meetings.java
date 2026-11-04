class Solution {
    public int countDays(int days, int[][] meetings) {

        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        int availableDays = 0;
        int lastDay = 0;

        for (int[] meeting : meetings) {

            if (meeting[0] > lastDay + 1) {
                availableDays += meeting[0] - lastDay - 1;
            }

            lastDay = Math.max(lastDay, meeting[1]);
        }

        return availableDays + days - lastDay;
    }
}