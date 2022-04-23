/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null) return null;
        nextRight(root);
        return root;
    }
   
    public void nextRight(Node node){
        if(node.left==null) return;
        node.left.next=node.right;
        if(node.next!=null) node.right.next=node.next.left;
        nextRight(node.left);
        nextRight(node.right);
        
    }
}
