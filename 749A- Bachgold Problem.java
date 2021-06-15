import java.util.*;
public class Main{
 public static void main(String[] args)
   { 
  Scanner sc=new Scanner(System.in);
  int n=sc.nextInt();
  int x=0;
  String s="";       
  System.out.println(n/2);
 
        if(n%2==0) {     
 
         for(int i=0;i<n/2;i++) {
          System.out.print(2+" ");
         }
 
        }
        else {
         for(int i=0;i<(n/2)-1;i++) {
          System.out.print(2+" ");
         }
 
         System.out.println(3);
        }
 
 }
 
}
