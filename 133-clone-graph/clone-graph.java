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
        if( root == null ) return null ;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        HashMap<Node, Node> visited = new HashMap<>();
        Node cloneGraph = new Node(root.val);
        visited.put(root, cloneGraph);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            Node currClone = visited.get(curr);
            for (Node n : curr.neighbors) {
                if (!visited.containsKey(n)) {
                    visited.put(n, new Node(n.val));
                    queue.offer(n);
                }
                currClone.neighbors.add( visited.get(n) ) ;
            }
        }
        return cloneGraph ;
    }
}