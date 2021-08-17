import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class StringTask {
  public static void main(String[] args) throws NumberFormatException, IOException {
     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
  String s=br.readLine();
  String ns="";
     
       
        s=s.toLowerCase();
      
     for(int i=0;i<s.length();i++) {
      char c=s.charAt(i);
       switch (c){
       case 'o': 
       case'a':
       case 'e':
       case 'i':
       case'u':
       case'y':
       break;
     default:
       
         ns=ns+'.';
      
        ns+=c;  
      }
      
     }
     System.out.println(ns);
  }
}
