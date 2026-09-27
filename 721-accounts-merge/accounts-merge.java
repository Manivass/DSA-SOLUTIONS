
class Solution {
    
    int[] parent;
    int[] rank;

    int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    void union(int x, int y) {
        int a = find(x);
        int b = find(y);
        if (a == b)
            return;

        if (rank[a] < rank[b]) {
            parent[a] = b;
        } else if (rank[b] < rank[a]) {
            parent[b] = a;
        } else {
            parent[b] = a;
            rank[a]++;
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        
        parent = new int[n] ;
        rank = new int[n] ;
        for( int i = 0 ; i < n ; i++ ) parent[i] = i ;

        List<List<String>> ans = new ArrayList<>() ;
        for( int  i = 0 ; i < n ; i++ ) ans.add( new ArrayList<>() ) ;
        for( int i = 0 ; i < n ; i++ ) ans.get(i).add( accounts.get(i).get(0) ) ;
        HashMap<String , Integer> map = new HashMap<>() ;
        for( int i = 0 ; i < n ; i++ ) {
            for( int j = 1 ; j < accounts.get(i).size() ; j++  ) {
                String str = accounts.get(i).get(j) ;
                if( map.containsKey(str) ) {
                    int containsIndex = map.get(str) ;
                    union( containsIndex , i ) ;
                }   
                else {
                    map.put( str , i ) ;
                }
            }
        }

        for( Map.Entry<String , Integer> entry : map.entrySet() ) {
            ans.get( find(entry.getValue()) ).add(entry.getKey() ) ; 
        }

        for( int i = 0 ; i < ans.size() ; i++ ) {
            if( ans.get(i).size() == 1 ) {
                ans.remove(i) ;
                i-- ;
            }
            else{
                Collections.sort(ans.get(i).subList(1, ans.get(i).size()));

            }
        }
        return ans ;
    }
}