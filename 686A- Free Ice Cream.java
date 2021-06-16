import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class FreeIcecream {
 
 
    public static void main(String[] args)  {
     
     Scanner s=new Scanner(System.in);
           int children=0;
       int t =s.nextInt();
 
    //System.out.println("test cases are "+t);
       int [] ans=new int[2*t];
   long icecream =s.nextInt();
   for(int i=0;i<t;i++) {
    String sign=s.next();
    //System.out.println("sign is "+sign);
    int packs =s.nextInt();
   // System.out.println("packs r "+packs);
   
    if(sign.equals("-")) {
     if(packs<=icecream) {
     icecream-=packs;
    // System.out.println("take these");
    }
     else {
      //System.out.println("sad child ");
      children++;
     }
    }
     if(sign.equals("+")) {
      //System.out.println("thx");
      icecream+=packs;
     }
     
    }
//    
  
   System.out.println(icecream+" "+children);
  
  
     
    }
  
}
