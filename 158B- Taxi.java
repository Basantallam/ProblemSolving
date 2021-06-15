 
import java.util.*;
public class Main{
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
 // System.out.println(Arrays.toString(arr));
  while(i<=j &&j>-1 && i<n) {
   if(arr[j]+arr[i]>4) {
  //  System.out.println("last only " +arr[j]);
    sum++;
    j--;
   }
   else {
    
    //System.out.print(arr[j] +"  ");
    int tempsum=arr[j];
    j--;
     while(i<n&&tempsum+arr[i]<=4) {
    // System.out.print(arr[i]);
     tempsum+=arr[i];
     i++;
    }
     
          //    System.out.println();
    sum++;
   }
  }
  System.out.println(sum);
  }
}
