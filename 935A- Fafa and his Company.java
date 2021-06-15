import java.util.Scanner;
public class yalla{
  public static void main(String[] args){
    Scanner input= new Scanner(System.in);
    double n=input.nextDouble();
    double i=n-1;
     int c=0;
    while (i>0){
      double x=n-i;
      if ((x)%i==0)
        {
        c=c+1;
        }
      i--;
    }
    System.out.println (c);
  }
};
