 
import java.util.Scanner;
public class collectingcoins {
 
  public static void main(String[] args) {
   Scanner sc=new Scanner(System.in);
   int t=sc.nextInt();
   while(t-->0) {
    int a=sc.nextInt();
    int b=sc.nextInt();
    int c=sc.nextInt();
    int n=sc.nextInt();
    
      
    int each=(n+a+b+c)/3;
    int A=each-a;
    int B=each-b;
    int C=each-c;
    if(A>=0 && B>=0&& C>=0 && A+B+C==n) {
     System.out.println("YES");
    }else {
     System.out.println("NO");
    }
   }
  }
}
 
