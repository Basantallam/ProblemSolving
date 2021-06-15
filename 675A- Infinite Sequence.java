import java.util.*;
public class Main{
 public static void main(String[] args)
   { 
  Scanner sc=new Scanner(System.in);
  int a=sc.nextInt();
  int b=sc.nextInt();
  int x=0;
  int c=sc.nextInt();
        x=b-a;
        boolean f=false;
        if(c==0 ||b==a) {
         f=true;
         if(a==b) {
          System.out.println("YES");
         }
        
        else {
         System.out.println("NO");
        }
        }
    if(!f)
     System.out.println(x%c==0 && (x/c)>0?"YES":"NO");
 }
 
}
