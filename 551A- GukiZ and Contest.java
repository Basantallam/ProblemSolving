import java.util.Arrays;
import java.util.Scanner;
 
public class GukiZ_and_Contest {
 
 public static void main(String[] args) {
  
  Scanner sc=new Scanner(System.in);
  int n=sc.nextInt();
  int  arr[]= new int[n];
  int freq[]= new int[2001];
  int csum[]= new int[2001];
  
  for(int i=0;i<n;i++) {
   arr[i]=sc.nextInt();
   freq[arr[i]]++; 
 
  }
  
  
  csum[2000]=0;
  for(int i=1999;i>=0;i--) {
   csum[i]=freq[i+1]+csum[i+1];
  }
  for(int i=0;i<n;i++) {
   System.out.print(csum[arr[i]]+1+" ");
  }
 }
 
}
