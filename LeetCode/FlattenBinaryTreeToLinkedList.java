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
    public void flat(TreeNode root) {
        flatten(root);
    }
    int x=0;
    public Pair<TreeNode,TreeNode> flatten (TreeNode root){

        x++;
        if(root==null) return null;
        Pair<TreeNode,TreeNode> ans;
        if(root.left==null&&root.right==null){
            ans=new Pair(root,root);
            return ans;
        }
        if(root.left==null)
        {
            Pair<TreeNode,TreeNode> right=flatten(root.right);
            ans=new Pair(root,right.getValue());
            return ans;
        }
        
          if(root.right==null)
        {
            Pair<TreeNode,TreeNode> left=flatten(root.left);
            root.right=left.getKey();
            root.left=null;
            ans=new Pair(root,left.getValue());
             return ans;
        }
        else{
             Pair<TreeNode,TreeNode> right=flatten(root.right);
        
            Pair<TreeNode,TreeNode> left=flatten(root.left);

            root.right=left.getKey();
            left.getValue().right=right.getKey();

             ans=new Pair(root,right.getValue());
            root.left=null;
        }


        return ans;
    }
}
