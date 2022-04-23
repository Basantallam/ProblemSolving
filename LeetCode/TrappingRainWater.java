class Solution {
    public int trap(int[] height) {
        int[] sMax = new int[height.length];
        int[] pMax = new int[height.length];

        sMax[height.length-1]=height[height.length-1];
        for(int i=height.length-2;i>=0;i--){
            sMax[i]=Math.max(sMax[i+1],height[i]);   
        }
        int ans=0;
        pMax[0]=height[0];
        for(int i=1;i<height.length;i++){
            pMax[i]=Math.max(pMax[i-1],height[i]);
        }
         for(int i=1;i<height.length;i++){
            ans+=Math.min(pMax[i],sMax[i])-height[i];
        }
        return ans;
    }
}
