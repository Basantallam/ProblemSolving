class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i=0;
        int j=0;
        
        List<int[]> ans=new ArrayList<int[]>();
        while(i<firstList.length&&j<secondList.length){
            int curr1 []=firstList[i];
            int curr2 []=secondList[j];

            if(curr1[1]>=curr2[1]&&curr1[0]<=curr2[0]){
                int temp[]=new int[2];
                temp[0]=curr2[0];
                temp[1]=curr2[1];
                ans.add(temp);
                j++;
            }
            else
            if(curr2[1]>=curr1[1]&&curr2[0]<=curr1[0]){
                int temp[]=new int[2];
                temp[0]=curr1[0];
                temp[1]=curr1[1];
                ans.add(temp);
                i++;
            }
            else if(curr1[0]>=curr2[0]&& curr1[0]<=curr2[1]&&curr1[1]>=curr2[1]){
                  int temp[]=new int[2];
                temp[0]=curr1[0];
                temp[1]=curr2[1];
                ans.add(temp);
                j++;
            }
           else if(curr2[0]>=curr1[0]&&curr2[0]<=curr1[1]&&curr2[1]>=curr1[1]){
                int temp[]=new int[2];
                temp[0]=curr2[0];
                temp[1]=curr1[1];
                ans.add(temp);
                i++;
            }
            else{
                if(curr1[0]>=curr2[1])
                    j++;
                
                if(curr1[0]<=curr2[1])
                    i++;
            }
            
            
        }
    

        int answer[][]=new int[ans.size()][2];
        i=0;
        for(int[] x:ans){
            answer[i]=x;
            i++;
        }
        return answer;

    }
    
}

// .     .
//   . .    or rev
    
// .    .
//    .   . or rev
    
