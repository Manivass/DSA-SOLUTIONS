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
        if( root == null ) return root ;
        Deque<Node> stack = new ArrayDeque<>() ;
        stack.push(root) ;
        Node cloneGraph = new Node( root.val ) ;
        HashMap<Node , Node> visited = new HashMap<>() ;
        visited.put( root , cloneGraph ) ;
        while( !stack.isEmpty() ) {
            Node curr = stack.pop() ;
            Node currClone = visited.get(curr) ;
            for( Node n : curr.neighbors ) {
                if( !visited.containsKey(n) ) {
                    visited.put( n , new Node( n.val ) ) ;
                    stack.push(n) ;
                }
                currClone.neighbors.add( visited.get(n) ) ;
            }
        }
        return cloneGraph ;
    }
}