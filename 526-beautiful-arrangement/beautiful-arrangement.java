class Solution {
    public int backtrack(int n, List<Integer> list) {
        if (list.size() == n)
            return 1;
        int count = 0 ;
        for (int i = 1; i <= n; i++) {
            if (!list.contains(i) && ((list.size() + 1 )% i == 0 || i % (list.size() + 1 ) == 0)) {
                list.add(i);
               count+= backtrack(n, list);
                list.remove(list.size() - 1);
            }
        }
        return count ;
    }

    public int countArrangement(int n) {
        List<Integer> list = new ArrayList<>();
        return backtrack(n, list);
    }
}