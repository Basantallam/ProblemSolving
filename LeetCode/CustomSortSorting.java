class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character,Integer> freq=new HashMap<Character,Integer>();
        for(int i=0;i<s.length();i++){
            freq.put(s.charAt(i),freq.getOrDefault(s.charAt(i),0)+1);
        }
        StringBuilder sb=new StringBuilder("");
        
        for(int i=0;i<order.length();i++){
            int count=freq.getOrDefault(order.charAt(i),0);
            while(count>0){
                sb.append(order.charAt(i));
                count--;
                if(count==0) freq.remove(order.charAt(i));
            }    
        }
        for (Map.Entry<Character, Integer> set :freq.entrySet()){
            int count = set.getValue();
            while(count>0){
                sb.append(set.getKey());
                count--;
            }
        }       
        return sb+"";
    }
}
