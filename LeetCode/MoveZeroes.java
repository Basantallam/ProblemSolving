class Solution {
    public void moveZeroes(int[] nums) {
        int startz=0;
        int lastz=startz;
        while(lastz<nums.length&& nums[lastz]!=0)            
            lastz++;
            
        startz=lastz;
        while(startz<nums.length){
            while(startz<nums.length && nums[startz]==0){
                startz++;
            }
            if(startz>=nums.length) break;
            swap(startz,lastz,nums);
            startz++;
            lastz++;
        }
}
    public void swap(int s,int l,int[]nums){
        int temp=nums[s];
        nums[s]=nums[l];
        nums[l]=temp;
    }
        
}
