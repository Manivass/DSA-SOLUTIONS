class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public void backtrack(int[] arr, int rem, int start, List<Integer> list) {
        if (rem == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if (rem < 0)
            return;
        for (int i = start; i < arr.length ; i++) {
            if (i > start && arr[i] == arr[i-1]) continue;
            list.add(arr[i]);
            backtrack(arr, rem - arr[i], i + 1 , list);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] arr, int t) {
        Arrays.sort(arr);
        List<Integer> list = new ArrayList<>();
        backtrack(arr, t, 0, list);
        return ans;
    }
}