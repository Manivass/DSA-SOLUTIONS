class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap< Integer , Integer > map = new HashMap<>() ;
        for( int num : nums ) map.put( num , map.getOrDefault( num , 0 ) + 1 ) ;
        int max = (int)Math.ceil( nums.length / 3 ) ;
        List<Integer> list = new ArrayList<>() ;
        for( Map.Entry<Integer,Integer> entry : map.entrySet() ) {
            if( entry.getValue() > max ) list.add( entry.getKey() ) ;
        }
        return list ;
    }
}