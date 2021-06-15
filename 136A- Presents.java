import java.util.Scanner;
import java.io.*; 
import java.util.*; 
public class Presents
{ 
 public static void main(String[] args){  
    Scanner inpt=new Scanner(System.in);
    int i=1;
    int n=inpt.nextInt();
    int[] a= new int[n+1];
    int[] b= new int[n+1];
    a[0]=0;
    while(i<=n)
      {
      int x=inpt.nextInt();
      a[i]=x;
      i++;
      }
      i=1;
    
      while (i<=n)
      {
       b[a[i]]=i;
       i++;
      }
      int h=1;
      while (h<=n)
      {
      System.out.print((b[h]+" "));
      h++;
      }
    }
}
