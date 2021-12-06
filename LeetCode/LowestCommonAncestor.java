/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return LCA(p.val,q.val,root);
    }
    
    public TreeNode LCA(int val1,int val2,TreeNode parent){
        if (val1==parent.val||val2==parent.val)
              return parent;
        
        TreeNode p1=null;
        TreeNode p2=null;
       
        if(parent.left!=null)
            p1=LCA(val1,val2,parent.left);
        
        if(parent.right!=null)
            p2=LCA(val1,val2,parent.right);
        
        if(p1!=null&&p2!=null)
            return parent;
        
        if(p1!=null)
              return p1;
        
          return p2;
                
    }
}
