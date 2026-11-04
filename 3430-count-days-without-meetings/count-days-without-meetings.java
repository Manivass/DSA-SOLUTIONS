class Solution {
    public int countDays(int days, int[][] meetings) {

        int n = meetings.length;

        if (n == 0) return days;

        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        int availableDays = 0;

        for (int i = 1; i < meetings[0][0]; i++)
            availableDays++;

        int lastDay = meetings[0][1];

        for (int i = 1; i < n; i++) {

            if (meetings[i][0] > lastDay)
                availableDays += meetings[i][0] - lastDay - 1;

            lastDay = Math.max(lastDay, meetings[i][1]);
        }

        for (int i = lastDay + 1; i <= days; i++)
            availableDays++;

        return availableDays;
    }
}