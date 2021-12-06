
public class Codec {

    public String serialize(TreeNode root) {
        if(root==null) return null; 
        return  ser(root);
    }
    
    public String ser(TreeNode root){
        if(root.right==null&&root.left==null)
            return root.val+"()()";
        if(root.right==null)
            return root.val+"("+ser(root.left)+")()"; //could've used StringBuilder for better complexity
        if(root.left==null)
         return root.val+"()("+ser(root.right)+")";
        
        return  root.val+"("+ser(root.left)+")("+ser(root.right)+")";
    }
    

    public TreeNode deserialize(String data) {
       if(data==null)
        return null;

       return des(data,-1,data.length()-1);
        
    }
    
    public TreeNode des(String s, int lo, int hi){

        if(lo==hi-1||hi==lo)
            return null;
        int i=lo+1;

        while(s.charAt(i)!='(')
            i++;
       TreeNode node = new TreeNode(Integer.parseInt(s.substring(lo+1,i)));
        int open=1;
        int j=i+1;
        while(open>0){
            if(s.charAt(j)=='(')
                open++;
            else if(s.charAt(j)==')')
                open--;
            j++;
        }

        node.left=des(s,i,j-1);
        node.right=des(s,j,hi-1);
        return node;
    }
}
