 
import java.util.*;
public class Taxi{
 public static void main(String[] args)
   {    
  Scanner sc=new Scanner(System.in);
  int n=sc.nextInt();
  int[] arr=new int[n];
  for(int i=0;i<n;i++) {
    arr[i]=sc.nextInt();
  }
  Arrays.sort(arr);
  int i=0;
  int j=n-1;
  boolean f=false;
  int sum=0;  
  while(i<=j &&j>-1 && i<n) {
   if(arr[j]+arr[i]>4) {
    sum++;
    j--;
   }
   else {
    int tempsum=arr[j];
    j--;
     while(i<n&&tempsum+arr[i]<=4) {
     tempsum+=arr[i];
     i++;
    }
    sum++;
   }
  }
  System.out.println(sum);
  }
}
