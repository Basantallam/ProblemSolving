 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Yalla {
 
 
    public static void main(String[] args)  {
   
        Scanner inpt=new Scanner(System.in);
         int z=inpt.nextInt();
         
         String s=inpt.next();
         int a=0;
         int d=0;
         int i=0;
         while (i<z){
           if (s.charAt(i)=='A'){
           a++;
           }
           else{
           d++;
           }
         i++;
         }
        if (a>d){
          System.out.println("Anton");
        }
        else if (a<d){
        System.out.println("Danik");
        }
        else 
        System.out.println("Friendship");
       }
     
  
  
     
    
  
}
