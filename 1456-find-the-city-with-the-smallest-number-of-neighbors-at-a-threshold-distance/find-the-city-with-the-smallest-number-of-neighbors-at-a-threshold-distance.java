class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<List<Integer>>> graph = new ArrayList<>();
        // for( int i = 0 ; i < n ; i++ ) graph.add( new ArrayList<>() ) ;
        // for( int[] num : edges ) {
        //     int u = num[0] ;
        //     int v = num[1] ;
        //     int dist = num[2] ;
        //     List<Integer> list1 = Arrays.asList( v , dist ) ;
        //     List<Integer> list2 = Arrays.asList( u , dist ) ;
        //     graph.get(u).add( new ArrayList<>(list1) ) ;
        //     graph.get(v).add( new ArrayList<>(list2) ) ;
        // }
        // System.out.print(graph) ;
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(grid[i], Integer.MAX_VALUE);
        for (int[] num : edges) {
            int u = num[0];
            int v = num[1];
            int dist = num[2];
            grid[u][v] = dist;
            grid[v][u] = dist;
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j)
                        continue;
                    if (grid[i][k] != Integer.MAX_VALUE && grid[k][j] != Integer.MAX_VALUE)
                        grid[i][j] = Math.min(grid[i][j], grid[i][k] + grid[k][j]);
                }
            }
        }

        int min = Integer.MAX_VALUE ;
        int ans = -1 ;
        for( int i = 0 ; i < n ; i++ ) {
            int count = 0 ;
            for( int j = 0 ; j < n ; j++ ) {
                if( i != j &&  grid[i][j] <= distanceThreshold ) {
                    count++ ;
                }
            }
            if( count <= min ) {
                min = count ;
                ans = i ;
            }
        }
        return ans ;
    }
}