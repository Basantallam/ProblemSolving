 
import java.util.*;
public class Main{
 public static void main(String[] args)
   { 
  Scanner sc=new Scanner(System.in);
  int n=sc.nextInt();
 int ans=n/100;
  ans+=(n%100)/20;
  ans+=n%20/10;
  ans+=n%10/5;
  ans+=n%5/1;
  System.out.println(ans);
  
   }
}
