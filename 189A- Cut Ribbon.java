import java.util.Arrays;
import java.util.Scanner;
 
public class CutRibbon {  //basic dp
    static final int INF=(int)1e9; 
    static int a;
    static int b;
    static int c;
    static int[] memo=new int[40000];
 public static void main(String[] args) {
  
       Scanner sc=new Scanner(System.in);
       int n=sc.nextInt();
       Arrays.fill(memo, -1);
       a=sc.nextInt();
       b=sc.nextInt();
       c=sc.nextInt();
       System.out.println(dp(n));
 }
 
 public static int dp(int rem) {
  if(rem==0)
      return 0;
  if (rem<0)
   return -INF;
  if(memo[rem]!=-1)
   return memo[rem];
  return memo[rem]=Math.max(dp(rem-a)+1, Math.max(dp(rem-b)+1,dp(rem-c)+1));
 }
 
}
