import java.util.Scanner;
import java.io.*; 
import java.util.*;
import java.lang.*;
public final class hihello {
  public static void main(String[] args){  
     Scanner inpt=new Scanner(System.in);
     int n= inpt.nextInt();
     int [][] a=new int[n][n];
        int i=0;
        int x=0;
        int z=0;
        int j=0;
       while (i<n){
       while (j<n) {
       if (i==0|| j==0)
      {
      a[i][j]=1;
       }
       else
       {
       x=a[i-1][j];
       z=a[i][j-1];
          a[i][j]=x+z;
       }
        j++;
       }i++;
       j=0;
       }
       i=0;
       j=0;
       
         System.out.println(a[n-1][n-1]);
        
        }
}
 
 
