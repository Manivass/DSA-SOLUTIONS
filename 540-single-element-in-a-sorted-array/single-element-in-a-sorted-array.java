class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int m = l + ((r - l) / 2);
            if (m > 0 && nums[m] == nums[m - 1]) {
                if ((m - l) % 2 != 0) {
                    l = m + 1 ;
                }
                else {
                    r = m - 2 ;
                }
            }
            else if( m < nums.length - 1 && nums[m] == nums[m+1] ) {
                if( (r - m ) % 2 == 1 ) {
                    r = m - 1 ;
                }
                else l = m + 2 ;
            }
            else return nums[m] ;
        }
        return nums[r] ;
    }
}