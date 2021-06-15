import java.util.Scanner;
import java.io.*; 
import java.util.*;
import java.lang.*;
public final class hihello {
  public static void main(String[] args){  
     Scanner inpt=new Scanner(System.in);
     String [] a=new String[6];
     a[0]="0";
     int i=1;
     int x=0,y=0;
     String s="";
       while (i<=5){
        a[i]= inpt.nextLine();
        
        if (!a[i].equals("0 0 0 0 0"))
             {
           y=i;
           s= s+a[i];
             }
        i++;
       }
       i=0;
       while (i<=8)
       {char c= s.charAt(i);
       char o =1;
        if (c=='1') {
         x=(i/2)+1;
        }
      i=i+2; 
      }
      int f=java.lang.Math.abs(x-3)+java.lang.Math.abs(y-3);
       System.out.println(f);
       }   
  
}
 
 
