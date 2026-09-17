class Solution {
    public boolean isValid( List<List<Integer>> rooms ) {
        if( rooms.size() == 0 ) return true ;

        Queue<Integer> q = new ArrayDeque<>() ;
        HashSet<Integer> visited = new HashSet<>() ;
        q.offer( 0 ) ;

        while( !q.isEmpty() ) {
            int curr = q.poll() ;
            if( visited.contains( curr ) ) continue ;
            for( int i = 0 ; i < rooms.get(curr).size() ; i++ ) {
                q.offer( rooms.get(curr).get(i) ) ;
            }
            visited.add(curr) ;
        }
        System.out.println(visited) ;
        return visited.size() == rooms.size() ;
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
       return isValid( rooms ) ;
    }
}