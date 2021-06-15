 
import java.util.*;
public class Main{
 public static void main(String[] args)
   {    
  Scanner sc=new Scanner(System.in);
  int n=sc.nextInt();
  int[] p=new int[n];
  int[] q=new int[n-1];
  
  int oneindex=0; 
  for(int i=0;i<n-1;i++) {
   q[i]=sc.nextInt();
  } 
  
  
 
 
  p[0]=0;
   for(int i=0 ;i<n-1;i++) {
    p[i+1]=p[i]+q[i];
   }
   int min=1000000;
//     System.out.println( "p "+Arrays.toString(p));
//     System.out.println("q "+ Arrays.toString(q));
     for(int i=0;i<n;i++) {
   if(p[i]<min) {//one is the last negative number in input array
       min=p[i];
    oneindex=i; //because indices in p =q+1
   }
  }
//  System.out.println("1 indx is "+ oneindex);
  int d=1-p[oneindex];
//   System.out.println(d);
  for(int i=0;i<n;i++) {
   p[i]=p[i]+d;
  }
  
  int[] srtd =new int[n];
  for(int i=0;i<n;i++) {
   srtd[i]=p[i];
  }
  Arrays.sort(srtd);
//   System.out.println( "p "+Arrays.toString(p));
 
  boolean permutation=true;
for(int i=0; i<n-1;i++) {
 if(srtd[i]+1!=srtd[i+1]) {
  permutation=false;
 }
}
 
if(permutation) {
for(int i=0; i<n;i++) {
   System.out.print( p[i]+((i==n-1)?"":" ")); 
}
}
else {
 System.out.println(-1);
}
 
   }
} 
