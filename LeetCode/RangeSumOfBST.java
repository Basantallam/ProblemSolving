class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        return sum(root,high,low);
    }
    
    public int sum(TreeNode node, int hi, int lo){
        if(node==null)
            return 0;
        int ans=0;
        if(node.val<=hi && node.val>=lo)
            ans+=node.val;
        
        if(node.val<lo)
            ans+=sum(node.right,hi,lo); 
        
        else if(node.val>hi)
            ans+=sum(node.left,hi,lo); 
        
        else
            ans+=sum(node.left,hi,lo)+sum(node.right,hi,lo); 
        
        return ans;
    }
}
