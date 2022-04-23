class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length<=1) return nums.length;
        
        int r=1;
        int l=0;
        while(r<nums.length){
            while(r<nums.length && nums[r]==nums[l])
                r++;
            if(r!=nums.length) nums[l+1]=nums[r];
            l++;
        }
        return l;
    }
}
