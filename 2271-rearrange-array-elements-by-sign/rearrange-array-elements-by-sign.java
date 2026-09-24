class Solution {
    public int[] rearrangeArray(int[] nums) {

        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();

        for (int num : nums) {
            if (num < 0)
                negative.add(num);
            else
                positive.add(num);
        }

        int i = 0;
        int j = 0;
        int k = 0;

        int[] arr = new int[nums.length];

        while (i != positive.size() && j != negative.size()) {

            if (k % 2 == 0) {
                arr[k] = positive.get(i);
                i++;
            } else {
                arr[k] = negative.get(j);
                j++;
            }

            k++;
        }

        while (i < positive.size()) {
            arr[k] = positive.get(i);
            i++;
            k++;
        }

        while (j < negative.size()) {
            arr[k] = negative.get(j);
            j++;
            k++;
        }

        return arr;
    }
}