import java.util.Scanner;
public class subtraction
{ 
 public static void main(String[] args){  
    Scanner inpt=new Scanner(System.in);
    String a=inpt.next();
    String b=inpt.next();
    int i=0;
    int x=Integer.parseInt(a);
    int k=Integer.parseInt(b);
    while (i<k)
    {
     if (x%10==0)
       x=x/10;
     else 
       x=x-1;
     i++;
    }
    System.out.println(x);
    }
}
