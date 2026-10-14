class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int m = grid.size() ;
        int n = grid.get(0).size() ;
        int[][] arr = new int[m][n] ;
        boolean[][] visited = new boolean[m][n] ;
        Queue<int[]> q = new ArrayDeque<>() ;
        for( int i = 0 ; i < m ; i++ ) {
            for( int j = 0 ; j < n ; j++ ) {
                if( grid.get(i).get(j) == 1 ) {
                    q.offer( new int[] { i , j } ) ;
                    arr[i][j] = 0 ;
                    visited[i][j] = true ;
                }       
            }
        }
        while( !q.isEmpty() ) {
            int[] curr = q.poll() ;
            int row = curr[0] ;
            int col = curr[1] ;
            int[] dr = { -1 , 1 , 0 , 0 } ;
            int[] dc = { 0 , 0 , -1 , 1 } ;
            for( int i = 0 ; i < 4 ; i++ ) {
                int newRow = dr[i] + row ;
                int newCol = dc[i] + col ;
                if( newRow < 0 || newRow >= m || newCol < 0 || newCol >= n ) continue ;
                if( arr[newRow][newCol] != 0 ) continue ;
                if( visited[newRow][newCol] ) continue ;
                visited[newRow][newCol] = true ;
                arr[newRow][newCol] = arr[row][col] + 1 ;
                q.offer( new int[] { newRow , newCol } ) ;
            }
        }
        for( int[] num : arr ) System.out.println(Arrays.toString(num)) ;
        for( int i = 0 ; i < m ; i++ ) {
            for( int j = 0 ; j < n ; j++ ) visited[i][j] = false ;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(( a , b ) -> Integer.compare(b[2] , a[2])) ;
        pq.offer( new int[] { 0 , 0 , arr[0][0] } ) ;
        while( !pq.isEmpty() ) {
            int[] curr = pq.poll() ;
            int row = curr[0] ;
            int col = curr[1] ;
            int val = curr[2] ;
            if( visited[row][col] ) continue ;
            visited[row][col] = true ;
            if( row == m - 1 && col == n - 1  ) return val ;
            int[] dr = { - 1 , 1 , 0 , 0 } ;
            int[] dc = { 0 , 0 , -1 , 1 } ;
            for( int i = 0 ; i < 4 ; i++ ) {
                int newRow = dr[i] + row ;
                int newCol = dc[i] + col ;
                if( newRow < 0 || newRow >= m || newCol < 0 || newCol >= n ) continue ;
                int newVal = Math.min( val  , arr[newRow][newCol] ) ;
                pq.offer( new int[] { newRow , newCol , newVal } ) ;
            }
        }
        return 0 ;
    }
}