class Solution {
    public void dfs(String depature, HashMap<String, List<String>> map, List<String> city) {
        if (!map.containsKey(depature)) {
            city.add(depature);
            return;
        }
        while (!map.get(depature).isEmpty()) {
            String arrival = map.get(depature).remove(0);
            dfs(arrival, map, city);
        }
        city.add(depature);

    }

    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            String depature = ticket.get(0);
            String arrival = ticket.get(1);
            if (!map.containsKey(depature))
                map.put(depature, new ArrayList<>());
            map.get(depature).add(arrival);
        }
        for (List<String> city : map.values())
            city.sort(null);
        List<String> city = new ArrayList<>() ;
        dfs("JFK", map, city);
        Collections.reverse(city);
        return city;
    }
}