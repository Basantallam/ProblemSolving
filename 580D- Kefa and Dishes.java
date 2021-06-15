import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class Main {
    static int sat[];
    static int arr[][];
    static int m;
    static int n;
    static int k;
    static long memo[][];
    public static void main (String[] args) {
  Scanner sc=new Scanner(System.in);
  n=sc.nextInt();
  m=sc.nextInt();
  k=sc.nextInt();
  sat=new int[n+1];
  memo=new long[19][1048576];
  for(int i=0;i<19;i++) 
   Arrays.fill(memo[i],-1);
  for(int i=1;i<=n;i++)
   sat[i]=sc.nextInt();
  
  arr=new int[n+1][n+1];
  
  for(int i=0;i<=n;i++) 
   Arrays.fill(arr[i], 0);
  
  for(int i=0;i<k;i++)
   arr[sc.nextInt()][sc.nextInt()]=sc.nextInt();
  long max=-1;
  for(int i=1;i<=n;i++) { 
//   System.out.println("initiated");
 
   max=Math.max(max, sat[i]+dp(i,(0|(1<<i))));
   
  }
  System.out.println(max);
 
  
  
 }
 
public static long dp(int idx, int msk){
     
   if(Integer.bitCount(msk)==m) 
     return 0;
    
   if(memo[idx][msk]!=-1) {
    return memo[idx][msk];
   }
    long max=-1;
    for(int i=1;i<=n;i++) { 
     if(visited(i,msk)||i==idx) {
       continue;
     }       
      int s=arr[idx][i]+sat[i];
      max=Math.max(s+dp(i,msk|(1<<i)),max);
     }
    
     return memo[idx][msk]=max;
     
    }
 
public static boolean visited(int idx,int msk)
{
 return ((1<<idx) & msk)==1<<idx;
}
 
}
