/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node root) {
        if (root == null)
            return null;
        Queue<Node> q = new ArrayDeque<>();
        HashMap<Node, Node> visited = new HashMap<>();
        q.offer(root) ;
        Node cloneGraph = new Node(root.val);
        visited.put(root, cloneGraph);
        while (!q.isEmpty()) {
            Node curr = q.poll();
            Node currClone = visited.get(curr);
            for (Node n : curr.neighbors) {
                if (!visited.containsKey(n)) {
                    visited.put(n, new Node(n.val));
                    q.offer(n);
                }
                currClone.neighbors.add(visited.get(n));
            }
        }
        return cloneGraph;
    }
}