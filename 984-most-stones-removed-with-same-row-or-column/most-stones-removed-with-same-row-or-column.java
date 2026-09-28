class Solution {

    int[] parent;
    int[] rank;

    public int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);

        return parent[x];
    }

    public void union(int x, int y) {

        int a = find(x);
        int b = find(y);

        if (a == b)
            return;

        if (rank[a] < rank[b]) {
            parent[a] = b;
        } 
        else if (rank[b] < rank[a]) {
            parent[b] = a;
        } 
        else {
            parent[b] = a;
            rank[a]++;
        }
    }

    public int removeStones(int[][] stones) {

        int n = stones.length;

        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                if (stones[i][0] == stones[j][0] ||
                    stones[i][1] == stones[j][1]) {

                    union(i, j);
                }
            }
        }

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            set.add(find(i));
        }

        return n - set.size();
    }
}