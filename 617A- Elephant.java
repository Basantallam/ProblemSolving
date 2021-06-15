import java.util.Scanner;
public class elephant
{ 
 public static void main(String[] args){  
    Scanner inpt=new Scanner(System.in);
    int x=inpt.nextInt();
    Scanner input= new Scanner(System.in);
    int c=0;
    while(x!=0){
    if (x>=5)
      x=x-5;
     else if (x>=4)
      x=x-4;
      else if (x>=3)
      x=x-3;
      else if (x>=2)
      x=x-2;
      else 
      x=x-1;
      c++;
    }
    System.out.println(c);
    }
}
