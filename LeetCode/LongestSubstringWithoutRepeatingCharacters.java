class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxSoFar=0;
        int len=0;
        HashMap<Character, Integer> map=new HashMap<Character,Integer>();
        int i=0;
        int start=0; 
        while(i<s.length()){
            if(map.containsKey(s.charAt(i))){
                int idx=map.get(s.charAt(i));
                if(idx>=start)
                {
                  start=idx+1;

                }
                map.replace(s.charAt(i),i);
                 
            }
            else{
                map.put(s.charAt(i),i);
            }
          len=i-start+1;
          maxSoFar=Math.max(maxSoFar,len); 
          i++;                        

        }
    
    return maxSoFar;                           
}
}
