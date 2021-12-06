class Solution {
    public int maxSubArray(int[] nums) {
        
        int ptr=0;
        int maxSum= (int) -1e4;
        int curSum=0;
        int len=nums.length;
        while(ptr<len){
            curSum+=nums[ptr];
            maxSum=Math.max(maxSum, curSum);
            if(curSum<0){
                curSum=0;
            }
            ptr++;
        }

        return maxSum;
    }
    
   
}
