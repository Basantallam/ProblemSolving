class Solution {
    int[] num;
    public int findPeakElement(int[] nums) {
        num=nums;
        return binarySearch(nums.length-1,0);
    }
    
    public int binarySearch(int hi, int lo){
        int mid=(hi+lo)/2;
        
        if(hi<=lo)
            return hi;
        
        if(num[mid]>num[mid+1]){
            return binarySearch(mid,lo);
        }
        else return binarySearch(hi,mid+1);
    }
}
