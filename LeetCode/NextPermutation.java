class NextPermutation {
    public void nextPermutation(int[] nums) {
        int l=nums.length-2;
        int r=nums.length-1;
        
        while(l>=0 && nums[l]>=nums[r]){
            l--;
            r--;
        }
        if(l==-1){
            Arrays.sort(nums);
          //  System.out.println(nums);
        }
        else{
            int minmax=100;
            int minmaxidx=0;
            for(int i=r;i<nums.length;i++){
                if(nums[i] > nums[l] && minmax >= nums[i]){
                    minmax=nums[i];
                    minmaxidx=i;    
                }
            }
         nums[minmaxidx]=nums[l];
         nums[l]=minmax;
        Arrays.sort(nums,r,nums.length);
       // System.out.println(Arrays.toString(nums));
    }

    }
}
