class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int currentGain = 0 ;
        int totalGain = 0 ;
        int ans = 0 ;
        for( int i = 0 ; i < gas.length ; i++ ) {
            int gain = gas[i] - cost[i] ;
            totalGain += gain ;
            currentGain += gain ;
            if( currentGain < 0 ) {
                ans = i + 1  ;
                currentGain = 0 ;
            }  
        }
        return totalGain < 0 ? -1 : ans ;
    }
}