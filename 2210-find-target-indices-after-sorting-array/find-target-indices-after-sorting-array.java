class Solution {
    public List<Integer> targetIndices(int[] arr, int target) {
        int k = 0 ;
        List<Integer> res = new ArrayList<>();
        
        for(int i = 0 ; i < arr.length - 1 ; i++ ){
            boolean isSwapped = false ;
            for(int j = 0 ; j < arr.length - i - 1 ; j++) {
                if( arr[j] > arr[j+1] ) {
                    int temp = arr[j] ;
                    arr[j] = arr[j+1] ;
                    arr[j+1] = temp ;
                    isSwapped = true ;
                }
            }
            if(!isSwapped) {
                break ;
            }
        }

        for( int i = 0 ; i < arr.length ; i++ ) {
            if(arr[i] == target) {
                res.add(i);
            }
        }
        return res ;
        
    }
}