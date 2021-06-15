import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Yalla {
 
 
    public static void main(String[] args)  {
    
     TreeSet <String> set=new TreeSet<>();
     boolean t=false;
     String n;
     int nn;
     String ns;
  try {
   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
     n = br.readLine();
     nn=Integer.parseInt(n);
     while(true) {
      nn++;
             ns=String.valueOf(nn);
   for(int i=0;i<ns.length();i++) {
     set.add(ns.charAt(i)+"");
     
   }
   //System.out.println(set);
        if (set.size()==4) {
        
         System.out.println(ns);
         break;
        }
        set.clear();
  }
  }
  catch (IOException e) {} 
     
     
    }
  
}
