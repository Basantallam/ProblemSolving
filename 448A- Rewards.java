import java.util.Scanner;
import java.lang.*;
public final class Rewards {
  public static void main(String[] args){  
     Scanner inpt=new Scanner(System.in);
     double cups=0;
        int i=0;
        double used=0;
        int c=0;
     while (i<3){
      
     double morecups= inpt.nextDouble();
     cups=cups+morecups;
      i++;
       }  
     i=0;
     double m=0;
     double morem;
     while (i<3){
            morem= inpt.nextDouble();
      m=m+morem;
       i++;
        }
    
    
     int s= inpt.nextInt();
    
     i=0;
           m=m/10;
           cups=cups/5;
            used=Math.ceil(m);
            
            double z =Math.ceil(cups);
            used=used + z;
          
     
  if (s>=used){
    System.out.println("YES");
  }
  else {
   System.out.println("NO");  
  }
  }
        }
 
 
