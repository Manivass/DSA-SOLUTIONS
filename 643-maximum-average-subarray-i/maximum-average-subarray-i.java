class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int j = 0 ;
        int i = 0 ;
        int max =  Integer.MIN_VALUE ;
        int sum = 0 ;
        while( j < nums.length  ) {
            sum += nums[j] ;
            if( j - i + 1 >= k ) {
                max = Math.max( max , sum ) ;
                sum-=nums[i] ;
                i++ ;
            }
            j++ ;
        }
        return (double)max / k ;
    }
}