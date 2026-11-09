class Solution {
    List<List<Integer>> ans = new ArrayList<>() ;
    public void backtrack( int[] arr , List<Integer> list , HashSet<Integer> set ) {
        if( list.size() == arr.length ) {
            ans.add( new ArrayList<>(list) ) ;
            return ;
        }
        for( int i = 0 ; i < arr.length ; i++ ) {
            if( !set.contains(arr[i]) ) {
                list.add(arr[i]) ;
                set.add(arr[i]) ;
                backtrack( arr , list , set ) ;
                list.remove( list.size() - 1 ) ;
                set.remove( arr[i] ) ;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>() ;
        HashSet<Integer> set = new HashSet<>() ;
        backtrack( nums , list  , set ) ;
        return ans ;
    }
}