class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n] ;
        Arrays.fill( dist , Integer.MAX_VALUE ) ;
        dist[src] = 0 ;
        for( int i = 0 ; i <= k ; i++ ) {
            int[] temp = dist.clone() ;
            for( int[] flight : flights ) {
                int from = flight[0] ;
                int to = flight[1] ;
                int amt = flight[2] ;
                if( dist[from] != Integer.MAX_VALUE ) {
                    temp[to] = Math.min( temp[to] , dist[from] + amt ) ;
                }
            }
            dist = temp ;
        }
        System.out.print(Arrays.toString(dist)) ;
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst] ;
    }
}