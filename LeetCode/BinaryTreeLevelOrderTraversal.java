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
    public List<List<Integer>> levelOrder(TreeNode root) {
        return BFS(root);
    }
    
    
    public List<List<Integer>> BFS(TreeNode root) {
       
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(root==null)
            return list;
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        Queue<TreeNode> q1=new LinkedList<TreeNode>();
        List<Integer> list1 = new ArrayList<Integer>();
        TreeNode curr=root;
        list1.add(curr.val);
        list.add(list1);
        q.add(root);
        
        while(!q.isEmpty()){
            list1 = new ArrayList<Integer>();
            q1=new LinkedList<TreeNode>(); 
               
                while(!q.isEmpty()){
                    curr=q.poll();
                    if(curr!=null){  
                        if(curr.left!=null){
                            list1.add(curr.left.val);   
                            q1.add(curr.left);
                        }
                        
                        if(curr.right!=null){
                            list1.add(curr.right.val);   
                            q1.add(curr.right); 
                        }
                    }
                }
                q=q1;
            if(list1.size()!=0)
                list.add(list1);
        }            
        return (list);

        }
}
