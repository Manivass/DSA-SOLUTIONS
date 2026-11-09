class Solution {
    int max = 0 ;
    int cnt = 1 ;
    public void backtrack( int[] arr , int index , int or, List<Integer> list ) {
        if( max == or ) cnt++ ;
        if( max < or ) {
            max = or ;
            cnt = 1 ;
        }
        if( index >= arr.length ) return ;
        for( int i = index ; i < arr.length ; i++ ) {
            list.add(arr[i]) ;
            int temp = or ;
            or = or | arr[i] ;
            backtrack( arr , i + 1 , or , list ) ;
            or = temp ;
            list.remove( list.size() - 1 ) ;
        }
    }
    public int countMaxOrSubsets(int[] nums) {
        List<Integer> list = new ArrayList<>() ;
        for( int i = 0 ; i < nums.length ; i++ ) {
            list.add( nums[i] ) ;
            backtrack( nums , i + 1 , nums[i] , list ) ;
            list.remove( list.size() - 1 ) ;
        }
        return cnt ;
    }
}