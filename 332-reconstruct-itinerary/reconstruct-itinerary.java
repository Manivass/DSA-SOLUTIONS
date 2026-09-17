class Solution {
    List<String> path = new ArrayList<>();

    public void dfs(String str, HashMap<String, List<String>> map) {
        if (!map.containsKey(str)) {
            path.add(str);
            return;

        }
            while (!map.get(str).isEmpty()) {
                String getCity = map.get(str).remove(0);
                dfs(getCity, map);
            }
            path.add(str);
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (List<String> subList : tickets) {
            if (!map.containsKey(subList.get(0)))
                map.put(subList.get(0), new ArrayList<>());
            map.get(subList.get(0)).add(subList.get(1));
        }
        for( List<String> list : map.values() ) list.sort(null) ;
        dfs("JFK", map);
        Collections.reverse(path);
        return path;
    }
}