import java.util.Scanner;
 
public class IntegerDividingSequence {
 
 public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
  long n=sc.nextLong();
        if( n%4==0 || n%4==3 ) {
         System.out.println(0);
        }
        else {
         System.out.println(1);
        }
         
  
 }
 
}
