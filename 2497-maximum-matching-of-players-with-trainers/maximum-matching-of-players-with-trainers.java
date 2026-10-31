class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players) ;
        Arrays.sort(trainers) ;
        int i = 0 ;
        int j = 0 ;
        int cnt = 0 ;
        while( i < players.length && j < trainers.length ) {
            if( trainers[j] >= players[i] ) {
                cnt++ ;
                i++ ;
            }
            j++ ;
        }
        return cnt ;

    }
}