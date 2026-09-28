class Solution {
    int[] parent;
    int[] rank;
    int[] size ;

    public int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    public void union(int x, int y) {
        int a = find(x);
        int b = find(y);
        if (a == b)
            return;
        if (rank[b] < rank[a]) {
            parent[b] = a;
            size[a]+=size[b] ;
        } else if (rank[a] < rank[b]) {
            parent[a] = b;
            size[b]+=size[a] ;
        } else {
            parent[b] = a;
            rank[a]++;
            size[a]+=size[b] ;
        }
    }

    public void dfs(int[][] grid, int i, int j, boolean[][] visited) {
        if (visited[i][j])
            return;
        int n = grid.length;
        visited[i][j] = true;
        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };
        for (int k = 0; k < 4; k++) {
            int row = dr[k] + i;
            int col = dc[k] + j;
            if (row < 0 || row >= grid.length || col < 0 || col >= grid.length)
                continue;
            if( grid[row][col] != 1 ) continue ;
            if (visited[row][col])
                continue;
            union(n * i + j, n * row + col);
            dfs(grid, row, col, visited);
        }
    }

    public int getIsland( int[][] grid , int i , int j , HashSet<Integer> set ) {
        int[] dr = { -1 , 1 , 0 , 0 } ;
        int[] dc = { 0 , 0 , -1 , 1 } ;
        int count = 0 ;
        for( int k = 0 ; k < 4 ; k++ ) {
            int row = dr[k] + i ;
            int col = dc[k] + j ;
            if( row < 0 || row >= grid.length || col < 0 || col >= grid.length ) continue ;
            if( grid[row][col] != 1 ) continue  ;
            int getparent = find( grid.length * row + col ) ;
            if( set.contains(getparent) ) continue ;
            count += size[getparent] ;
            set.add(getparent) ;
        }
        return count ;

    }

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        parent = new int[n * n];
        rank = new int[n * n];
        size = new int[n*n] ;
        for (int i = 0; i < n * n; i++)
        {
            size[i] = 1 ;
            parent[i] = i;
        }
            
        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    if (visited[i][j])
                        continue;
                    dfs(grid, i, j, visited);
                }
            }
        }

        int count = 0 ;
        for( int i = 0 ; i < n ; i++ ) {
            for( int j = 0  ; j < n ; j++ ) {
                if( grid[i][j] == 0 ) {
                    count = Math.max( count , getIsland( grid , i , j , new HashSet<>()) + 1 );
                }
            }
        }

        if( count == 0 ) return n* n;
        return count;
    }
}