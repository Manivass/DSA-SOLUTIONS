
class Solution {

    List<Integer> ans = new ArrayList<>();

    public boolean backtrack(String num, int index,
                             List<Integer> list) {

        if (index == num.length()) {
            if (list.size() >= 3) {
                ans = new ArrayList<>(list);
                return true;
            }
            return false;
        }

        long curr = 0;

        for (int i = index; i < num.length(); i++) {

            if (i > index && num.charAt(index) == '0')
                break;

            curr = curr * 10 + (num.charAt(i) - '0');

            if (curr > Integer.MAX_VALUE)
                break;

            int size = list.size();

            if (size >= 2) {

                long sum = (long) list.get(size - 1)
                         + list.get(size - 2);

                if (curr < sum)
                    continue;

                if (curr > sum)
                    break;
            }

            list.add((int) curr);

            if (backtrack(num, i + 1, list))
                return true;

            list.remove(list.size() - 1);
        }

        return false;
    }

    public List<Integer> splitIntoFibonacci(String num) {
        backtrack(num, 0, new ArrayList<>());
        return ans;
    }
}
