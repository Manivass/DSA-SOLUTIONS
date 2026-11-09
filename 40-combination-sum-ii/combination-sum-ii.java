class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public void backtrack(int[] arr, int index, int t, List<Integer> list) {
        if (t == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if (t < 0)
            return;
        for (int i = index; i < arr.length; i++) {
            if( i != index && arr[i] == arr[i-1] ) continue ;
            list.add(arr[i]);
            backtrack(arr, i + 1, t - arr[i], list);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        Arrays.sort(arr);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if( i != 0 && arr[i] == arr[i-1] ) continue ;
            list.add(arr[i]);
            backtrack(arr, i + 1, target - arr[i], list);
            list.remove(list.size() - 1);
        }
        return ans ; 
    }
}