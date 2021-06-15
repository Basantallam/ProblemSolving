import java.util.Scanner;
 
public class HamstersAndTigers {
 
 public static void main(String[] args) {
 
  Scanner sc=new Scanner(System.in);
  int n=sc.nextInt();
  String s=sc.next();
  int hamsters=0;
  for(int i=0;i<n;i++) {
   if(s.charAt(i)=='H') {
    hamsters++;
   }
  }
  int min=1001;
  
  for(int i=0;i<n;i++) {
   int temp=0;
   for(int j=i;j<i+hamsters;j++) {
    int idx=j%n;
    if(s.charAt(idx)=='T') {
     temp++;
    }
   }
   min=Math.min(temp, min);
  }
  System.out.println(min);
 }
 
}
