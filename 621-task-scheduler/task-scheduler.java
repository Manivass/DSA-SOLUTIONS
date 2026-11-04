class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character , Integer> map = new HashMap<>() ;
        for( int i = 0 ; i < tasks.length ; i++ ) {
            char ch = tasks[i] ;
            map.put( ch , map.getOrDefault( ch , 0 ) + 1 ) ;
        }
        int maxFreq = 0 ;
        int maxFreqCount = 1 ;
        for( int max : map.values() ) {
            if( maxFreq == max ) {
                maxFreqCount++ ;
            } 
            else if( max > maxFreq ) {
                maxFreq = max ;
                maxFreqCount = 1 ;
            }
        }
        return Math.max( ( n + 1 ) * ( maxFreq - 1 ) + maxFreqCount , tasks.length ) ;
    }
}