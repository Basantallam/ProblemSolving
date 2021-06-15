 
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
 
public class DIYWoodenLadder {
 
 public static void main(String[] args) {
 
  Scanner sc=new Scanner(System.in);
  int t=sc.nextInt();
  PrintWriter pw=new PrintWriter(System.out);
  
  while (t-- >0) {
   int n=sc.nextInt();
   int arr[]=new int[n];
   int max1=0;
   int max2=0;
   boolean flag=false;
   for(int i=0;i<n;i++){
    arr[i]=sc.nextInt();
    
    if(arr[i]>max1) {
     if(max1>max2)
      max2=max1;
     max1=arr[i];
    }
    else {
     if(arr[i]>max2)
      max2=arr[i];
    }
    if(arr[i]==0)
     flag=true;
   }
   
    
   int k=Math.min(n-2, max2-1);
            if(flag)
             k=0;
   pw.println(k);
   
  }
  pw.flush();
 }
 
}
