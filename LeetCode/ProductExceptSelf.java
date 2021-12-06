class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod=1;
        int zeroes=0;
        for(int i=0;i<nums.length;i++){
           if(nums[i]==0){
               zeroes++;
           }
            else
                prod*=nums[i];
        }
        
        int ans[]=new int[nums.length];
        for(int i=0;i<nums.length;i++)
            if(zeroes>0&&(nums[i]!=0||(nums[i]==0&&zeroes>1)))
                ans[i]=0;
            else
                if(nums[i]==0)
                    ans[i]=prod;
                else
                    ans[i]=prod/nums[i];
        
        return ans;
    }
}
