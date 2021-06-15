import java.util.Arrays;
import java.util.Scanner;
 
public class Vacations {
 static int[] d;
 static int INF=(int)1e9;
 static int memo[][];
 public static void main(String[] args) {
  Scanner sc=new Scanner(System.in);
  int n=sc.nextInt();
  d=new int[n];
  memo=new int[101][3];
  for(int i=0;i<=100;i++)
   Arrays.fill(memo[i], -1);
  for(int i=0;i<n;i++) {
   d[i]=sc.nextInt();
  }
  System.out.println(dp(-1,0));
 }
 
 public static int dp(int idx, int currstate) {
  if(idx==d.length-1)
   return 0;
  if(memo[idx+1][currstate]!=-1) {
   return memo[idx+1][currstate];
  }
  if(d[idx+1]==0) { 
   return memo[idx+1][currstate]=dp(idx+1,0)+1;
   //rest
  }
  
 else {
  if(d[idx+1]==1) {//contest day
   if(currstate==1) {
    return memo[idx+1][currstate]= dp(idx+1,0)+1;
              //was contest
   }
   else
    return memo[idx+1][currstate]=dp(idx+1,1); //do contest
  }
  else {//gym day
   if(d[idx+1]==2) {
    if(currstate==2) {
     return memo[idx+1][currstate]= dp(idx+1,0)+1;//rest
     //was gym
    }
    else
     return memo[idx+1][currstate]= dp(idx+1,2); //go gym
   }
   else {//both
    int g=INF;
    int c=INF;
    if(currstate==1)
     g=dp(idx+1,2); 
    else if(currstate==2)
     c= dp(idx+1,1);
    else {
     g=dp(idx+1,2); 
     c= dp(idx+1,1);
    }
    return memo[idx+1][currstate]=Math.min(g, c);
   }
  }
 }
}
}
