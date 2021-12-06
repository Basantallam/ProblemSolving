class Solution {
    public int minAddToMakeValid(String string) {
        Stack <Integer> open=new Stack();
        Set <Integer>remove=new TreeSet();
        int closed=0;
        char[] s=string.toCharArray();
        for(int i=0;i<s.length;i++){
            if(s[i]=='('){
                open.add(i);
            }
            else if(s[i]==')'){
                if(open.isEmpty()){
                    remove.add(i);
                    closed++;
                }
                else{
                    open.pop();
                }
            }
        }
        
        return open.size()+remove.size();
    }
}
