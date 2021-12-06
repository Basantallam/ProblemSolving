class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        int preSum=0;
        map.put(0,1);
        int count=0;
        for(int i=0;i<nums.length;i++){
            preSum+=nums[i];
           
            if(map.containsKey(preSum-k)){
               count+= map.get(preSum-k);
            } 
            
            if(map.containsKey(preSum)){
                int val=map.get(preSum);
                map.replace(preSum,val+1);
            }
            else{
                map.put(preSum,1);
            }
        }
        
        return (count);
    }
}
