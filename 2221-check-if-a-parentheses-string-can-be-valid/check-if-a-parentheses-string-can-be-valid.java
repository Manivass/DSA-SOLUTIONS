class Solution {
    public boolean canBeValid(String s, String locked) {
        Deque<Integer> open = new ArrayDeque<>() ;
        Deque<Integer> lock = new ArrayDeque<>() ;
        for( int i = 0 ; i < s.length() ; i++ ) {
            char paranthesis = s.charAt(i) ;
            char locker = locked.charAt(i) ;
            if( locker == '0' ) lock.push(i) ;
            else if( paranthesis == '(' ) open.push(i) ;
            else {
                if( !open.isEmpty() ) open.pop() ;
                else if( !lock.isEmpty() ) lock.pop() ;
                else return false ;
            }
        }
        while( !open.isEmpty() && !lock.isEmpty() ) {
            if( open.pop() > lock.pop() ) return false ;
        }
        return open.isEmpty() && lock.size() % 2 == 0 ;
    }
}