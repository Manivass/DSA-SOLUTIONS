class Solution {
    HashMap<String , long[]> dp = new HashMap<>() ;
    public long[] backtrack(int[][] arr, int i, int j) {
        if (i == arr.length - 1 && j == arr[0].length - 1)
            return new long[] { arr[i][j], arr[i][j] };
        long min = Long.MAX_VALUE ;
        long max = Long.MIN_VALUE ;
        String key = i + "-" + j ;
        if( dp.containsKey(key) ) return dp.get(key) ;

        if( j + 1 < arr[0].length ) {
            long[] right = backtrack( arr , i , j + 1 ) ;

            long p1 = arr[i][j] * right[0] ;
            long p2 = arr[i][j] * right[1] ;

            min = Math.min( min , Math.min( p1 , p2 ) ) ;
            max = Math.max( max , Math.max( p1 , p2 ) ) ;
        }
        if( i + 1 < arr.length ) {
            long[] down = backtrack( arr , i + 1 , j  ) ;

            long p1 = arr[i][j] * down[0] ;
            long p2 = arr[i][j] * down[1] ;

            min = Math.min( min , Math.min( p1 , p2 ) ) ;
            max = Math.max( max , Math.max( p1 , p2 ) ) ;
        }
        dp.put( key , new long[] { min , max } ) ;
        return new long[] { min , max } ;
    }

    public int maxProductPath(int[][] grid) {
        long[] ans = backtrack(grid, 0, 0);
        if( ans[1] < 0 ) return -1 ;
        return (int) (ans[1] % 1000000007 ) ;
    }
}