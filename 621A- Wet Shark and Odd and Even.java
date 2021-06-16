import java.util.*;
public class Main{
 public static void main(String[] args)
   { 
  Scanner sc=new Scanner(System.in);
  int n=sc.nextInt();
  long sum=0;
  long minodd=(long) 2000000001;
  long t=0;
        for(int i=0; i<n; i++) {
         t=sc.nextInt();
         if(t%2!=0 && t<minodd)
          minodd=t;
         sum+=t;
        }
        if(sum%2!=0) {
         sum-=minodd;
        }
   System.out.println(sum);
   }
}
