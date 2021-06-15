import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;
 
public class BearAndFiveCards {
 
 public static void main(String[] args) {
  Scanner sc=new Scanner(System.in);
  int[] arr=new int[5];
  
  
  int sum=0;
   for(int i=0;i<5;i++) {
    sum+=arr[i]=sc.nextInt();
   }
   int ctr=1;
   int max=0;
   Arrays.sort(arr);
   int temp=arr[4];
  for(int i=3;i>=0;i--) { 
//   System.out.println(ctr+" "+temp+ " "+i+" "+max);
 
   if(arr[i]==temp) {
    ctr++;
    if(i==0) { 
 
     if(ctr==2) {
        if(max<2*temp) 
         max=2*temp;
       }
         else if(ctr>2) {
        if(max<3*temp) {
         max=3*temp;
        }
       }
     ctr=1;
     }
    
   }
   else {
     if(ctr==2) {
      if(max<2*temp) 
       max=2*temp;
     }else if(ctr>2) {
      if(max<3*temp) {
       max=3*temp;
      }
     }
   ctr=1;
   }
    temp= arr[i];
 }
 
 
  System.out.println(sum-max);
 
 }
}
