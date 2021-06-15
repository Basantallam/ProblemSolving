import java.util.Scanner;
public class InSearchOfAnEasyProblem
{ 
 public static void main(String[] args){  
    Scanner inpt=new Scanner(System.in);
    int i=0;
    int n=inpt.nextInt();
    int[] a= new int[100];
    boolean F=true;
    while(i<n)
      {
      int b=inpt.nextInt();
      a[i]=b;
      i++;
      }
      i=0;
      while (i<n && F)
      {
       if (a[i]!=0) 
         {F=false;
         }
       i++;
      }
      if (F )
        System.out.println("EASY");
      else 
        System.out.println("HARD");
    }
}
