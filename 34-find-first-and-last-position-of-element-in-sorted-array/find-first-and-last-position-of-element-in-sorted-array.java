class Solution {
    public int[] searchRange(int[] arr, int target) {
        int l = 0 ;
        int r = arr.length - 1 ;
        int[] ans = new int[2] ;
        Arrays.fill(ans , -1) ;
        while( l <= r ) {
            int mid = l + ( r - l ) / 2 ;
            if( arr[mid] == target ) {
                ans[0] = mid ;
                r = mid - 1 ;
            }
            else if( arr[mid] > target ) {
                r = mid - 1 ;
            }
            else l = mid + 1 ;
        }
         l = 0 ;
        r = arr.length - 1 ;
        while( l <= r ) {
            int mid = l + ( r - l ) / 2 ;
            if( arr[mid] == target ) {
                ans[1] = mid ;
                l = mid + 1 ;
            }
            else if( arr[mid] > target ) {
                r = mid - 1 ;
            }
            else l = mid + 1 ;
        }
        return ans ;
    }
}