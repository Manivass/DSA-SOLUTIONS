class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort( costs , ( a , b ) -> ( b[1] - b[0] ) - ( a[1] - a[0] ) ) ;
        int n = costs.length / 2 ;
        int sum = 0 ;
        for( int i = 0 ; i < n ; i++ ) {
            sum += costs[i][0] ;
            sum += costs[i+n][1] ;
        }
        return sum ;
    }
}