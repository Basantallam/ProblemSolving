class Solution {
    public String addBinary(String a, String b) {
        int zeroes=0;
        int alen=a.length();
        int blen=b.length();
        if(alen>blen){
            zeroes=alen-blen;
            for(int i=0;i<zeroes;i++)
                b="0"+b;
        }
        else{
            zeroes=blen-alen;
            for(int i=0;i<zeroes;i++)
                a="0"+a;
        }

        int ptr=Math.max(alen,blen)-1;
        boolean carry=false;
        String ans=("");  //could've used StringBuilder for faster runtime
        while (ptr>=0){
                if(a.charAt(ptr)!=b.charAt(ptr)){ //1+0

                        if(carry){
                            ans="0"+ans;
                            carry=true;
                        }   
                        else
                            ans="1"+ans;
                        
                }
                else if(a.charAt(ptr)=='1'){ //a[i]='1' b[i]='1'

                    if(b.charAt(ptr)=='1'){
                        if(carry){
                            ans="1"+ans;
                            carry=true;
                        }   
                        else{
                            ans="0"+ans;
                            carry=true;
                        }  
                }
            }
            else{ 
                     if(carry)
                    {
                        ans="1"+ans;
                        carry=false;
                    }
                    else
                        ans="0"+ans;
                    
                }                   
       ptr--;          
    }
    if(carry)
        ans='1'+ans;
    return ans;

    }
}
