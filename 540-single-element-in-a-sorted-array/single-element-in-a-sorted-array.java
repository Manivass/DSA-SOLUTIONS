class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + ((r - l) / 2);
            if (mid > 0 && nums[mid] == nums[mid - 1]) {
                if ((mid - l) % 2 == 0) {
                    r = mid - 2;
                } else
                    l = mid + 1;
            }
            else if( mid < nums.length - 1 && nums[mid] == nums[mid + 1] ) {
                if( (r - mid) % 2 == 0 ) {
                    l = mid + 2 ;
                }
                else r = mid - 1 ;
            }
            else return nums[mid] ;
        }
        return nums[r] ;
    }
}