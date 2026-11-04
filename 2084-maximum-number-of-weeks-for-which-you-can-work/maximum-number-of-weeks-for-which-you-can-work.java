class Solution {
    public long numberOfWeeks(int[] arr) {
        long sum = 0 ;
        long max = 0 ;
        for( int num : arr ) {
            sum += num ;
            max = Math.max( max , num ) ;
        }
        long remaining = sum - max ;
        if( max <= remaining + 1 ) return sum ;
        return 2 * remaining + 1 ;
    }
}