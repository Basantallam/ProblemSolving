import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class BeautifulYear {
 
 
    public static void main(String[] args) throws IOException {
    
     TreeSet <String> set=new TreeSet<>();
     boolean t=false;
     String n;
     int nn;
     String ns;

     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
     n = br.readLine();
     nn=Integer.parseInt(n);
     while(true) {
       nn++;
       ns=String.valueOf(nn);
       for(int i=0;i<ns.length();i++) 
         set.add(ns.charAt(i)+"");
         if (set.size()==4) {
           System.out.println(ns);
           break;
         }
         set.clear();
      } 
    
    }
  
}
