class Solution {
    HashSet<Integer> set = new HashSet<>() ;
    public boolean canReach(int[] arr, int st) {
        if( st < 0 || st >= arr.length ) return false ;
        if( arr[st] == 0 ) return true ;
        if( set.contains(st) ) return false ;
        set.add( st ) ;
        return arr[st] == 0 || canReach( arr , st + arr[st] ) || canReach( arr , st - arr[st] ) ;
    }
}