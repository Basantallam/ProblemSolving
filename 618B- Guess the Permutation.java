import java.util.*;
public class GuessThePermutation{
 public static void main(String[] args)
   { 
  Scanner sc=new Scanner(System.in);
   int n=sc.nextInt();
   int [][]a=new int[n][n];
  for(int i=0;i<n;i++) {
   for(int j=0;j<n;j++) {
    a[i][j]=sc.nextInt();
    
   }
  }
   int sol[]=new int[n];
   int max=-1;
   for(int i=0;i<n;i++) {
    for(int j=0;j<n;j++) {
    if(a[i][j]>max) 
     max=a[i][j];
    }
    sol[i]=max;
    max=-1;
   }
   boolean nos[]=new boolean [n+1];
   Arrays.fill(nos, false);
   for(int i=0;i<n;i++) {
   nos[sol[i]]=true;
   }
 
   for(int i=1;i<n+1;i++) {
    if(!nos[i]) {
     for(int j=0;j<n;j++) {
      if(sol[j]==i-1) {
       sol[j]=sol[j]+1;
       
       break;
      }
     }
    }
    }
for(int i=0;i<n;i++) {
 System.out.print(sol[i]+" ");
}
   }
}
