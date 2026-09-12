class Solution {

    HashMap<Integer, Integer> dp = new HashMap<>();

    public boolean isBalanced(int[] freq) {

        int count = 0;

        for (int x : freq) {

            if (x == 0)
                continue;

            if (count == 0)
                count = x;

            else if (count != x)
                return false;
        }

        return true;
    }

    public int backtrack(String s, int st) {

        if (st == s.length())
            return 0;

        if (dp.containsKey(st))
            return dp.get(st);

        int min = Integer.MAX_VALUE;

        int[] freq = new int[26];

        for (int i = st; i < s.length(); i++) {

            freq[s.charAt(i) - 'a']++;

            if (isBalanced(freq)) {

                int res = backtrack(s, i + 1);

                min = Math.min(min, 1 + res);
            }
        }

        dp.put(st, min);

        return min;
    }

    public int minimumSubstringsInPartition(String s) {
        return backtrack(s, 0);
    }
}