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
    public List<Integer> rightSideView(TreeNode root) {
       
        List<Integer> list = new ArrayList<Integer>();
        if(root==null)
            return list;
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        Queue<TreeNode> q1=new LinkedList<TreeNode>();

        q.add(root);
        
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
                  
            if(curr!=null){
                list.add(curr.val);   
                q1=new LinkedList<TreeNode>();
                q1.add(curr.right);
                q1.add(curr.left);
                while(!q.isEmpty()){
                    curr=q.poll();
                    if(curr!=null){
                        q1.add(curr.right);
                        q1.add(curr.left);
                    }
                }
                q=q1;
            }
            
        }
        return (list);
    }
    
   
}
