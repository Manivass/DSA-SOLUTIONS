class Solution {
    int count = 0 ;
    public void backtrack( int[] arr , int st , List<Integer> list , int newDiff ) {
        if( list.size() >= 3 ) count++ ;
        if( st >= arr.length ) return ;
        if( list.size() == 1 ) {
            newDiff = arr[st] - list.get( list.size() - 1 ) ;
            list.add(arr[st]) ;
            backtrack( arr , st + 1 , list , newDiff ) ;
            list.remove( list.size() - 1 ) ;
        }
        else
        {
            int lastEle = list.get( list.size() - 1 ) ;
            if( arr[st] - lastEle == newDiff ) {
                list.add(arr[st]) ;
                backtrack( arr , st + 1 , list , newDiff ) ;
                list.remove( list.size() - 1 ) ;
            }
        }
    }
    public int numberOfArithmeticSlices(int[] arr) {
        List<Integer> list = new ArrayList<>() ;
        int sum = 0 ;
        for( int i = 0 ; i < arr.length ; i++ ) {
            list.add(arr[i]) ;
             backtrack( arr , i + 1 , list , 0 ) ;
            list.remove( list.size() - 1 );
        }
        return count ;
    }
}