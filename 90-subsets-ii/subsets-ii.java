class Solution {
    List<List<Integer>> ans = new ArrayList<>() ;
    public void backtrack( int[] arr , int index , List<Integer> list ) {
        ans.add( new ArrayList<>(list) ) ;
        if( index >= arr.length ) return ;
        for( int i = index ; i < arr.length ; i++ ) {
            if( i > index && arr[i] == arr[i-1] ) continue ;
            list.add(arr[i]) ;
            backtrack( arr , i + 1 , list ) ;
            list.remove( list.size() - 1 ) ;
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort( nums ) ;
        List<Integer> list = new ArrayList<>() ;
        backtrack( nums , 0 , list ) ;
        return ans ;
    }
}