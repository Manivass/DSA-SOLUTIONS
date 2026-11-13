class Solution {
    public int minimumRounds(int[] tasks) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        int cnt = 0;

        for(int value : map.values()) {

            if(value == 1) return -1;

            cnt += (value + 2) / 3;
        }

        return cnt;
    }
}