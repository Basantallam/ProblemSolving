 
import java.util.Scanner;
 
public class AmrAndPins {
 
 public static void main(String[] args) {
  Scanner sc=new Scanner(System.in);
  int r=sc.nextInt();
  long x=sc.nextInt();
  long y=sc.nextInt();
  long nx=sc.nextInt();
  long ny=sc.nextInt();
  double d=Math.sqrt(((nx-x)*(nx-x))+((ny-y)*(ny-y)));
  
  System.out.println((int)Math.ceil(d/(2*r)));
 }
 
}
