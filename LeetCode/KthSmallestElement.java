class KthSmallestElement { //Binary Search Tree
    public int kthSmallest(TreeNode root, int k) {
        return traverse(root,k).val;
    }
    
    public Pair traverse(TreeNode node, int rem){

        if(node.left!=null){
            Pair l= traverse(node.left,rem);
            if(l.rem==0) return l;
            rem=l.rem;
        }
        
        Pair curr= new Pair(rem-1,node.val);
        if(curr.rem==0) return curr;
        
        if(node.right!=null) return traverse(node.right,curr.rem);
        return curr;
        
    }
       

    static class Pair{
        int rem;
        int val;
        Pair(int r, int v){
            rem=r;
            val=v;
        }
    }
}
