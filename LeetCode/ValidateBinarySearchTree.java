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
    public boolean isValidBST(TreeNode root) {
        if(root==null)
            return true;
        
        List<Integer> list=new ArrayList<Integer>();
        validate(root,list);
        long prev=-Long.MAX_VALUE;
        for(Integer x:list){
            if(prev>=x)
                return false;
            prev=x;
        }
        return true;
    }
    
    public static void validate(TreeNode node, List list){ //inorder traversal
        if(node==null)
            return;
        
        validate(node.left,list);
        list.add(node.val);
        validate(node.right,list);
    }
}
