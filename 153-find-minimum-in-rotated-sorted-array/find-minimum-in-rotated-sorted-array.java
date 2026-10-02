class Solution {
    public int findMin(int[] arr) {
        int l = 0 ;
        int r = arr.length - 1 ;
        while( l <= r ) {
            if( arr[l] <= arr[r] ) return arr[l] ;
            int mid = l + (( r - l)/2) ;
            if( mid > 0 && arr[mid] < arr[mid - 1] ) return arr[mid] ;
            if( arr[mid] < arr[l] ) {
                r = mid ;
            }  
            else
            {
                l = mid + 1 ;
            }
        }   
        return -1 ;
    }
}