class Solution {
    int count = 0 ;
    public int[] merge( int[] num1 , int[] num2 ) {
        int i = 0 ;
        int j = 0 ;
        int n = num1.length + num2.length ;
        int k = 0 ;
        int[] sortedArr = new int[n] ;
        while( i < num1.length && j < num2.length && k < n  ) {
            if( num1[i] <= num2[j] ) {
                sortedArr[k++] = num1[i++] ;
            }
            else sortedArr[k++] = num2[j++] ;
        }
        while( i < num1.length ) {
            sortedArr[k++] = num1[i++] ;
        }
        while( j < num2.length ) {
            sortedArr[k++] = num2[j++] ;
        }
        return sortedArr ;
    }

    public void getCountPairs( int[] num1 , int[] num2 ) {
        int i = 0 ; 
        int j = 0 ; 
        int n1 = num1.length ;
        int n2 = num2.length ;
        while( i < num1.length && j < num2.length ) {
            if( num1[i] > (long) num2[j] * 2 ) {
                count+= num1.length - i ;
                j++ ;
            }
            else{
                i++ ;
            }
        }
    }

    public int[] mergeSort(int[] nums) {
        if(nums.length <= 1) return nums ;
        int mid = (int)Math.floor(nums.length / 2);
        int[] left = mergeSort(Arrays.copyOfRange(nums , 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(nums , mid, nums.length));
        getCountPairs( left , right ) ;
        return merge(left, right);
    }

    public int reversePairs(int[] nums) {
        int[] ans = mergeSort(nums);
        System.out.println(Arrays.toString(ans)) ;
        return count ;
    }
}