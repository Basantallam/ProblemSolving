import java.util.Scanner;
 
public class QuasiBinary {
 public static void main(String[] args) {
 
  Scanner sc=new Scanner(System.in);
  int n=sc.nextInt();
  String s=Integer.toString(n);
  int max=-1;
  for(int i=1;i<=s.length();i++) {
   max=Math.max(max, (int)(n%Math.pow(10, i)/Math.pow(10, i-1)));
  }
  System.out.println(max);
  quasi(n);
  System.out.println();
 
 }
 public static int quasi(int n) {
  if(n<=0)
   return 0;
  int len=(Integer.toString(n)).length();
  int N=0;
  for(int i=1;i<=len;i++) {
 
   if((int)(n%Math.pow(10, i)/Math.pow(10, i-1))!=0) {
    N+=(int)Math.pow(10, i-1);
   }
  }
  System.out.print(N+" ");
  return quasi(n-N)+1;
 }
 
}
