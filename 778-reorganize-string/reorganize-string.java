class Solution {
    public String reorganizeString(String s) {
        HashMap<Character , Integer> map = new HashMap<>() ;
        for( char ch : s.toCharArray() ) {
            map.put( ch , map.getOrDefault( ch , 0 ) + 1 ) ;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(( a , b ) -> b[1] - a[1] ) ;
        for( Map.Entry<Character , Integer> entry : map.entrySet()) {
            pq.offer(new int[] { (int)entry.getKey() , entry.getValue()  }) ;
        }
        int k = 0 ;
        StringBuilder str = new StringBuilder() ;
        int[] curr = pq.poll() ;
        char ch = (char) curr[0]  ;
        int val =  curr[1] ;
        str.append(ch) ;
        char prevCh = ch ;
        int prevFeq = val - 1 ;
        while( !pq.isEmpty()   ) {
            curr = pq.poll() ;
            ch = (char) curr[0] ;
            val = curr[1] ;
            str.append(ch) ;
            if( prevFeq > 0 ) {
                pq.offer( new int[] { (int) prevCh , prevFeq } ) ;
            }
            prevCh = ch ;
            prevFeq = val - 1 ;
        }
        return str.length() == s.length() ? str.toString() : "" ;
        
    }
}