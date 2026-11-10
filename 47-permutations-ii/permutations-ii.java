class Solution {
    List<List<Integer>> ans = new ArrayList<>() ;
    public void backtrack( int[] arr , List<Integer>  list , int n ) {
        if( list.size() == n ) {
            ans.add(new ArrayList<>(list)) ;
            return ;
        }
        for( int i = 0 ; i < arr.length ; i++ ) {
            if( i > 0 && arr[i] == arr[i-1] ) continue ;
            list.add(arr[i]) ;
            int[] newArr = new int[arr.length-1] ;
            int k = 0 ;
            for( int j = 0 ; j < arr.length ; j++ ) {
                if( i == j ) continue ;
                newArr[k++] = arr[j] ;
            }
            backtrack( newArr , list , n ) ;
            list.remove( list.size() - 1 ) ;
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums) ;
        List<Integer> list = new ArrayList<>() ;
        backtrack( nums , list , nums.length ) ;
        return ans ;
    }
}