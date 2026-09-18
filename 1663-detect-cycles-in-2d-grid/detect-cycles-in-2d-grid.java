class Solution {
    HashMap<String , Boolean> dp = new HashMap<>() ;
    public boolean dfs(char[][] grid, int i, int j, int lastRow, int lastCol, char ch, HashSet<String> visited) {
        String key = i + "-" + j;
        visited.add(key);
        String dpKey = i +"-"+j+"-"+lastRow + "-" + lastCol + "-" + ch ;
        if( dp.containsKey( dpKey ) ) return dp.get( dpKey ) ; 
        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };
        for (int k = 0; k < 4; k++) {
            int row = dr[k] + i;
            int col = dc[k] + j;

            if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length)
                continue;

            if ((lastRow == row && lastCol == col) || grid[row][col] != ch)
                continue;

            if (visited.contains(row + "-" + col)){
                dp.put( dpKey , true ) ;
                return true ;
            }

            if (dfs(grid, row, col, i, j, ch, visited)){
                dp.put( dpKey , true ) ;
                return true ;
            }

        }
        dp.put( dpKey , false ) ;
        return false ;
    }

    public boolean containsCycle(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (dfs(grid, i, j, -1, -1, grid[i][j], new HashSet<>()))
                    return true;

            }
     
        }
        return false ;
    }
}