class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] amount = new int[2] ;
        for( int amt : bills ) {
            if( amt == 5 ) {
                amount[0]++ ;
            }
            else if( amt == 10 ) {
                amount[1]++ ;
                amount[0]-- ;
            }
            else {
                if( amount[1] > 0 ) {
                    amount[1]-- ;
                    amount[0]-- ;
                }
                else {
                    amount[0] = amount[0] - 3 ;
                }
            }
            if( amount[0] < 0 ) return false ;
        }
        return true ;
    }
}