import java.util.Scanner;
import java.io.*; 
import java.util.*;
import java.lang.*;
public final class hihello {
  public static void main(String[] args){  
     Scanner inpt=new Scanner(System.in);
     int n= inpt.nextInt();
        int l=inpt.nextInt();
        int i=0;
        int sum=0;
        int[] a=new int[n];
       while (i<n){
       a[i]=inpt.nextInt();
       i++;
       }
       i=0;
       while (i<n){
       if (a[i]>l)
       { sum=sum+2;
       }
        else
       { sum++;
       }
        i++;
        }
     System.out.println(sum);
        
        }
}
 
 
