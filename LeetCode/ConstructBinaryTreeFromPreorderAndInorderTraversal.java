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
    static HashMap<Integer,Integer> map;
    static int[] pre;
    static int[] in;

    static int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map=new HashMap<Integer,Integer>();
        idx=0;
        pre=preorder;
        in=inorder;
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i],i);
        
        return traverse(0,pre.length-1);
    }

 
    public static TreeNode traverse(int i, int j){
        if(i>j||i<0||j>=pre.length)
            return null;
        if(i==j){
            TreeNode node = new TreeNode(pre[idx]);
            idx++;
            return node;
        }
        int mid=map.get(pre[idx]);
        TreeNode node = new TreeNode(pre[idx]);
        idx++;
        node.left=traverse(i,mid-1);
        
        node.right=traverse(mid+1,j);
        
        return node;
    }
}
