import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
import java.util.TreeSet;
public class RaisingBacteria {

    public static void main(String[] args) throws IOException {    
       int n;
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       int c=0;
       n = Integer.parseInt(br.readLine());
       String b=Integer.toBinaryString(n);
  // System.out.println(b);
      for(int i=0;i<b.length();i++) 
        if (b.charAt(i)=='1') 
          c++;
      System.out.println(c); 
     
    }
  
}
