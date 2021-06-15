import java.util.Arrays;import java.util.Scanner;
public class IQTest {
 public static void main(String[] args) {
 
  Scanner sc=new Scanner(System.in);
  int n = sc.nextInt();
  int even = 0;
  int odd = 0;
     int [] arr=new int[n];
     
     for(int i=0;i<n;i++) {
      arr[i]=sc.nextInt()%2;
      if(arr[i]==0)
       even++;
      else
       odd++;
     }
//     System.out.println( Arrays.toString(arr));
     int ctr=-1;
     if(odd>even) {
      while(arr[++ctr]!=0) {
      
      }
     System.out.println(ctr+1);
     }
     else {
      while(arr[++ctr]!=1) {
      
      }
     System.out.println(ctr+1);
 }
 }
}
