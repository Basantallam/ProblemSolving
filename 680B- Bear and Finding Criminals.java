import java.util.Scanner;
import java.lang.*;
public final class hihello {
  public static void main(String[] args){  
     Scanner inpt=new Scanner(System.in);
     int ctch=0;
     int n=inpt.nextInt();
     int pc=inpt.nextInt();
        int i=1;
        int [] a=new int[n+1];
        a[0]=0;
     while (i<=n){
      
     a[i]= inpt.nextInt();
  
      i++;
       }  
     i=1;
     while (i<=n){
    if (a[i]==1){  
      if (i==pc){
       ctch++;
       
      }
      else {
      int d= Math.abs(pc-i);
      if (d<pc &&(pc+d<=n)) {
        if (a[d+pc]==a[pc-d]){
       ctch++;
       
      }
      }
        else  {
        
            ctch++;
        }
      
     }
    }
       i++;
        }  
     System.out.println(ctch);
     
  }
        }
 
 
