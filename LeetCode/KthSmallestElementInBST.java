/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    static int rem;
    public int kthSmallest(TreeNode root, int k) {
        rem=k;
        return traverse(root);
    }
    
    public int traverse(TreeNode node){

        if(node.left!=null){
             int x=traverse(node.left);
            if(rem==0) return x;
        }
        
        rem--;

        if(rem==0) return  node.val;

        if(node.right!=null) return traverse(node.right);
        return -1;
        
    }
       


}
