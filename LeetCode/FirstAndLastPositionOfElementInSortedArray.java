class Solution {
    int[] num;
    public int[] searchRange(int[] nums, int target) {
        num=nums;
        int ans[] = new int[2];
        ans[0]=-1; ans[1]=-1;
        
        if(nums.length==0) return ans;

        int i = binarySearch(num.length-1,0,target);
       
        if (i==-1) return ans;
       
        int j=i;
        while( i<num.length && num[i]==target){
            i++;
        }
        i--;
         while(j>=0 && num[j]==target){
            j--;
        }
        j++;
        ans[0]=j; ans[1]=i;
        return ans;
    }                       
    
    public int binarySearch(int hi, int lo,int target){
        int mid= (hi+lo)/2;
        
         if(num[mid]==target)
            return mid;
        
        if(hi<lo)
            return -1;  
       
        if(hi==lo)
            return -1;
        
      
        if(num[mid]>target)
            return binarySearch(mid,lo,target);
        
        return binarySearch(hi,mid+1,target);
        
    }

}
