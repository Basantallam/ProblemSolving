 
import java.util.Arrays;
import java.util.Scanner;
 
public class JzzhuAndSequences {
 
 public static void main(String[] args) {
  Scanner sc=new Scanner(System.in);
  int [] arr=new int[6];
        arr[0]=mod(sc.nextInt());
        arr[1]=mod(sc.nextInt());
        int n=sc.nextInt() -1;
        
        for(int i=2;i<6;i++) {
         arr[i]=mod(arr[i-1]-arr[i-2]);
//            System.out.println(arr[i]);
        }      
        int idx= n%6 ;
//        System.out.println( idx);
        System.out.println(arr[idx]);
 }
 
 public static int mod(int n) {
  while(n<0) {
   n+=1000000007;
  }
  return n; 
 }
 
}
