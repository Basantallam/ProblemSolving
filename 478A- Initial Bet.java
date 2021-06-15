import java.util.*;
public class Main{
 public static void main(String[] args)
   { 
  Scanner sc=new Scanner(System.in);
  int n1=sc.nextInt();
  int n2=sc.nextInt();
     int n3=sc.nextInt();
     int n4=sc.nextInt();
     int n5=sc.nextInt();
 
     if((n1+n2+n3+n4+n5)%5==0&&(n1!=0||n2!=0||n3!=0||n4!=0||n5!=0))
      System.out.println((n1+n2+n3+n4+n5)/5);
      
     
     else 
      System.out.println(-1);
     
     
   }
}
