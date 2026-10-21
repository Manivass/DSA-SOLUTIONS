class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> sq = new ArrayDeque<>() ;
        int i = 0;
        int j = 0 ;
        int[] ans = new int[nums.length-k+1] ;
        while( j < nums.length ) {
            while( !sq.isEmpty() && sq.peekLast() < nums[j] ) sq.removeLast() ;
            sq.addLast(nums[j]) ;
            if( j >= k - 1 ) {
                ans[i] = sq.peekFirst() ;
                if( nums[i] == ans[i] ) sq.removeFirst() ;
                i++ ;
            }
            j++ ;
        }
        return ans ;
    }
}