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
    public String tree2str(TreeNode root) {
        // if(root==null)
        //     return;
        return str(root);
    }
    public String str(TreeNode root){
        if(root.right==null&&root.left==null)
            return root.val+"";
        if(root.right==null)
            return root.val+"("+str(root.left)+")"; //could've used StringBuilder for faster runtime
        if(root.left==null)
         return root.val+"()("+str(root.right)+")";
        
        return  root.val+"("+str(root.left)+")("+str(root.right)+")";
    }
    
    // left only: r(x)
    //right only: r()(x)
    //none: r
    // both: r(x)(y)
}
