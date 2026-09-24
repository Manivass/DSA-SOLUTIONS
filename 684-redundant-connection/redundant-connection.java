class Solution {
    int[] parent ;
    int[] rank ;
    public int find ( int x ) {
        if( parent[x] != x ) parent[x] = find( parent[x] ) ;
        return parent[x] ;
    }
    public boolean union( int x , int y ) {
        int a = find(x) ;
        int b = find(y) ;
        if( a == b ) return false ;
        if( rank[a] < rank[b] ) parent[a] = b ;
        else if( rank[b] < rank[a] ) parent[b] = a ;
        else {
            parent[b] = a ;
            rank[a]++ ;
        }
        return true ;
    }
    public int[] findRedundantConnection(int[][] edges) {
        int m = edges.length ;
        parent = new int[m] ;
        rank = new int[m] ;
        for( int i = 0 ; i < m ; i++ ) parent[i] = i ;
        for( int[] num : edges ) {
            int u = num[0] - 1 ;
            int v = num[1] - 1 ;
            if( union( u , v ) ) {

            }  
            else{
                return num ;
            }
        }
        return new int[] {0} ;
    }
}