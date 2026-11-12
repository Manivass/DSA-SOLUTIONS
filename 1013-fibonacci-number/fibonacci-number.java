class Solution {
    int[] arr;
    public int fibo( int n ) {
        if( n <= 1 ) return n ;
        arr[n - 1] = fibo( n - 1 ) + fibo( n - 2 ) ;
        return arr[n -1 ] ;
    }
    public int fib(int n) {
        if( n <= 1 ) return n ;
        arr = new int[n] ;
        int ans = fibo( n ) ;
        return arr[n - 1] ;
    }
}