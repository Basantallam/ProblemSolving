import java.util.Arrays;
import java.util.Scanner;
 
public class Queue {
  public static void main(String[] args) {
   Scanner sc=new Scanner(System.in);
   int n=sc.nextInt();
   int[] arr=new int[n];
   
   for(int i=0;i<n;i++) {
    arr[i]=sc.nextInt();
   }
   
   Arrays.sort(arr);
   int sum=0;
//      System.out.println(Arrays.toString(arr));
   int nd=0;
   for(int i=0;i<n;i++) {
//    System.out.println(sum+" "+arr[i]);
   if(arr[i]>=sum){
    nd++;
    sum+=arr[i];
   }
   }
 
   
   System.out.println(nd);
  }
}
