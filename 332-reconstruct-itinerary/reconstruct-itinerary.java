class Solution {

    public void dfs( String city , HashMap<String , List<String>> map , List<String> path ) {
        if( !map.containsKey(city) ) {
            path.add(city) ;
            return ;
        }

        while( !map.get(city).isEmpty() ) {
            String getCity = map.get(city).remove(0) ;
            dfs(getCity , map , path) ;
        }
        path.add(city) ;
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String , List<String>> map = new HashMap<>() ;
        for( List<String> city : tickets ) {
            String dept = city.get(0) ;
            String arrival = city.get(1) ;
            if( !map.containsKey( dept ) ) map.put( dept , new ArrayList<>() ) ;
            map.get(dept).add( arrival ) ;
        }


        for( List<String> val : map.values() ) val.sort(null) ;
        List<String> path = new ArrayList<>() ;
        dfs( "JFK" , map , path ) ;
        Collections.reverse(path) ;
        return path ;
    }
}