class Solution {
    List<List<Integer>> ans = new ArrayList<>() ;
    public void backtrack( List<Integer> list , int[] arr , int index ) {
        ans.add( new ArrayList<>(list) ) ;
        if( index == arr.length ) return ;
        for( int i = index ; i <  arr.length ; i++ ) {
            list.add( arr[i] ) ;
            backtrack( list , arr , i + 1 ) ;
            list.remove( list.size() - 1 ) ;
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<>() ;
        backtrack( list , nums , 0 ) ;
        return ans ;
    }
}