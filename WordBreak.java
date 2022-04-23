class Solution {
        HashSet<String> set;
        int[] works;
    public boolean wordBreak(String s, List<String> wordDict) {
        set=new HashSet<String>();
        works=new int[s.length()+1];
        Arrays.fill(works,-1);
        set.addAll(wordDict);
        return tryy(0,s);
        
    }
    
    public boolean tryy(int i,String s){
        if(i==s.length()) return true;
        if(works[i]==1) return true;
        if(works[i]==0) return false;

        for(int j=i;j<s.length() && j<i+20;j++){
            if(tryy(j+1,s)){
                if(set.contains(s.substring(i,j+1))){       
                    works[i]=1;
                     return true;
                }
            }
        }
        works[i]=0;
        return false;
    }
}
