class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length==1)
            return nums[0];
        return binarySearch(0,nums.length-1,nums);
    }
    
    public int binarySearch(int lo, int hi, int[] nums){
        int mid=(hi+lo)/2;
        if(mid+1<nums.length && nums[mid]!=nums[mid+1])
            if((mid-1>=0&&nums[mid]!=nums[mid-1])||mid-1<0)
                return nums[mid];
        if(mid-1>=0&& nums[mid]!=nums[mid-1])
            if((mid+1<nums.length && nums[mid]!=nums[mid+1])||mid+1>=nums.length )
                return nums[mid];   
        
        boolean even=(mid%2==0);
        if(even){
            if(nums[mid]==nums[mid+1]) return binarySearch(mid+1,hi,nums);
            else return binarySearch(lo,mid-1,nums);

        }
        else{
          if(nums[mid]==nums[mid+1]) return binarySearch(lo,mid-1,nums);
            else return binarySearch(mid+1,hi,nums);
        }
        
    }
}
