class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        boolean up=true;
        int i=0;
        int j=0;
        int[] ans=new int [mat[0].length*mat.length];
        int ptr=0;
        while(ptr<ans.length){
             if(j==mat[0].length){
                j--;
                i+=2;
                up=!up;
            }
            else
            if(i==mat.length){
                i--;
                j+=2;
                up=!up;
            }
            else
            if(i<0){
                i++;
                up=!up;
            }
            else if(j<0){
                j++;
                up=!up;

            }
            else{
                ans[ptr++]=mat[i][j];
                if(up){
                    j++;
                    i--;
                }
                else{
                    i++;
                    j--;
                }
            }
        }
      return ans;  
    }
    
}
