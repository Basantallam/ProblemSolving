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
    public boolean hasPathSum(TreeNode node, int targetSum) {
        if(node==null) return false;
        return sum(node, 0,targetSum);
    }
    
    public boolean sum(TreeNode node, int sum, int target){
        
        if(node.left==null && node.right==null)
            return (sum+node.val==target);
        
        boolean b1=false; boolean b2=false;
        if(node.left!=null) b1=sum(node.left,sum+node.val,target);
        if(node.right!=null) b2=sum(node.right,sum+node.val,target);
        return b1||b2;
    }
}
