class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer,Integer> win = new HashMap<>() ;
        HashMap<Integer,Integer> lost = new HashMap<>() ;
        HashSet<Integer> set = new HashSet<>() ;
        for( int[] match : matches ) {
            int winner = match[0] ;
            int loser = match[1] ;
            lost.put( loser , lost.getOrDefault( loser , 0 ) + 1 ) ;
            if( !set.contains(winner) ) set.add(winner) ;
            if( !set.contains(loser) ) set.add(loser) ;
        }
        List<List<Integer>> ans = new ArrayList<>() ;
        List<Integer> list = new ArrayList<>() ;
        for( int num : set ) list.add(num) ;
        list.sort(null) ;
        for( int i = 0 ; i < 2 ; i++ ) ans.add(new ArrayList<>()) ;
        for( int num : list ) {
            if( !lost.containsKey(num) ) {
                ans.get(0).add(num) ;
            }
            else if( lost.get(num) == 1 ) ans.get(1).add(num) ;
        }
        return ans ;
    }
}