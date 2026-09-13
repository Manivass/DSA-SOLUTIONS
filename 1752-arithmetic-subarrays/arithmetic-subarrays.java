class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] arr, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList<>() ;
        for( int i = 0 ; i < r.length ; i++ ) {
            int[] newArr = new int[r[i] - l[i] + 1] ;
            int k = 0 ;
            for( int j = l[i] ; j < r[i] + 1 ; j++ ) {
                newArr[k++] = arr[j] ;
            }
            Arrays.sort(newArr) ;

            int diff = Integer.MAX_VALUE ;
            boolean subAns = true ;
            for( k = 1 ; k < newArr.length ; k++ ) {
                if( k == 1 ) diff = newArr[k] - newArr[0] ;
                else if( newArr[k] - newArr[k-1] != diff ) {
                    subAns = false ;
                    break ;
                }
            }
            ans.add(subAns) ;
        }
        return ans ;
    }
}