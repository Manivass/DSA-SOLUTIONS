class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1])
                twoSum(nums, i);
        }
        return res ;
    }

    public void twoSum(int[] arr, int x) {
        int num = arr[x];
        int l = x + 1;
        int r = arr.length - 1;
        while (l < r) {
            int sum = num + arr[l] + arr[r];
            if (sum > 0)
                r--;
            else if (sum < 0)
                l++;
            else {
                List<Integer> list = Arrays.asList(num, arr[l], arr[r]);
                res.add(new ArrayList<>(list));
                l++;
                r-- ;
                while( l < r && arr[l] == arr[l-1] ) l++;
            }
        }
    }
}