class Solution {
    public int[] singleNumber(int[] nums) {
        
        HashSet<Integer> set = new HashSet<>() ;
        HashMap<Integer,Integer> map = new HashMap<>() ;
        for( int num : nums ) {
            if(!set.contains(num) ) set.add(num) ;
        }
        for( int num : nums ) {
            map.put( num , map.getOrDefault( num , 0 ) + 1 ) ;
            if( map.get(num) >= 2 ) set.remove(num) ;
        }
        int[] lst = new int[set.size()] ;
        int k = 0 ;
        for( int num : set ) {
            lst[k++] = num ;
        }  
        return lst ; 
    }
}