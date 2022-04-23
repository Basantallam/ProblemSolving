class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] ans=new int[nums.length];
        int l=0;
        int r=nums.length-1;
        int ptr=nums.length-1;
        while(l<=r){
            if(Math.abs(nums[l])<Math.abs(nums[r])){
                ans[ptr]=nums[r]*nums[r];
                ptr--;
                r--;
            }
            else
            {
                ans[ptr]=nums[l]*nums[l];
                ptr--;
                l++;
            }
        }
        return ans;
    }
}
