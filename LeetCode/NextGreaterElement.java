class Solution {
    public int nextGreaterElement(int n) {
        char[] arr = (n+"").toCharArray();
        int i = arr.length-2;
        while(i>=0 && (arr[i]-'0')>= (arr[i+1]-'0')){
            i--;
        }

        int x = i+1;
        if(i==-1)
            return -1;
        while(x<arr.length && arr[x]-'0'>arr[i]-'0'){
            x++;
        }
        x--;

        char temp= arr[x];
        arr[x]=arr[i];
        arr[i]=temp;
        
      rev(arr,i+1,arr.length-1);
      long max=Integer.MAX_VALUE;
      if(Long.parseLong(new String(arr))>max)
          return -1;
        return Integer.parseInt(new String(arr));
    
    }
    
    public void rev(char[] arr,int lo,int hi){
        if(hi==lo||hi<lo){
            return;
        }
        char temp=arr[hi];
        arr[hi]=arr[lo];
        arr[lo]=temp;
        rev(arr,lo+1,hi-1);
    }
}
