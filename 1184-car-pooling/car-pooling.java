class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] loc = new int[1001] ;
        for( int i = 0 ; i < trips.length ; i++ ) {
            int[] pass = trips[i] ;
            int passenger = pass[0] ;
            int from = pass[1] ;
            int to = pass[2] ;
            loc[from] = loc[from] + passenger ; 
            loc[to] = loc[to] - passenger ; 
        }
        int maxCapacity = 0 ;
        for( int i = 0 ; i < 1001 ; i++ ) {
            maxCapacity += loc[i] ;
            if( maxCapacity > capacity ) return false ;
        }
        return true ;
    }
}