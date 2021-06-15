import java.util.*;
public class Main{
 public static void main(String[] args)
   { 
  Scanner sc=new Scanner(System.in);
  int n=sc.nextInt();
  int m=sc.nextInt();
     int a=sc.nextInt();
     double b=sc.nextDouble();
     int x;
     double spec=b/m;
     if(spec<a) {
      x=n/m;
      x*=b;
      int y=(n%m)*a;
      
      if(y<b) {
       x+=y;
      }else {
       x+=b;
      }
      System.out.println(x);
     }else {
      System.out.println(a*n);
     }
     
   }
}
