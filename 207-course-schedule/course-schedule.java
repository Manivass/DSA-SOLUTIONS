class Solution {
    int[] visited ;
    public boolean dfs ( int num , List<Integer>[] adjList ) {
        if( visited[num] == 1 ) return false ;
        if( visited[num] == 2 ) return true ;
        visited[num] = 1 ;
        for( int neighbor : adjList[num] ) {
            if( !dfs( neighbor , adjList ) ) return false ;
        }
        visited[num] = 2 ;
        return true ;
    }
    public boolean canFinish(int n, int[][] prerequisites) {
        List<Integer>[] adjList = new List[n] ;
        for( int i = 0 ; i < n ; i++ ) adjList[i] = new ArrayList<>() ;
        for( int[] num : prerequisites ) {
            adjList[num[0]].add(num[1]) ;
        }
        visited = new int[n] ;
        for( int i = 0 ; i < n ; i++ ) {
            if( visited[i] == 0 ) {
                if( !dfs( i , adjList ) ) return false ;
            }
        }
        return true ;
    }
}