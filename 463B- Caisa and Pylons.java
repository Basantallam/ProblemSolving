import java.util.Arrays;
import java.util.Scanner;
 
public class Caisa_and_Pylons {
static int[]H;
static int INF=(int)1e9;
static int memo[];
 public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       int n=sc.nextInt();
       H=new int[n+1];
       H[0]=0;
       
       memo=new int[n+1];
         Arrays.fill(memo, -1);
       
              for(int i=1;i<=n;i++) {
        H[i]=sc.nextInt();
       }
       System.out.println(dp(0,0));
 }
 
 
 public static int dp(int idx, int energy) {
  if(idx==H.length-1)
   return 0;
  if(energy<0)
   return INF;
  if(memo[idx]!=-1){
//   System.out.println("used mem");
   return memo[idx];
  }
  int hop=INF;
  int pay=INF;
  if(H[idx]<H[idx+1])
  {
   if(energy+H[idx]-H[idx+1]>0) {//no coins needed
    return memo[idx]=dp(idx+1,energy+H[idx]-H[idx+1]);
   }
   else { //coins taken beqadr el 7aga
    return memo[idx]=dp(idx+1,0)+H[idx+1]-H[idx]-energy;
   }
  }
  else {
    hop=dp(idx+1, energy+H[idx]-H[idx+1]);
    pay=dp(idx+1, energy)+H[idx]-H[idx+1];
    return  memo[idx]=Math.min(hop, pay);
  }
 }
}
