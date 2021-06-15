import java.util.Scanner;
public final class hihello {
  public static void main(String[] args){  
     Scanner inpt=new Scanner(System.in);
     int n= inpt.nextInt();
     int x=inpt.nextInt();
        int i=1;
        int c=0;
     while (i<=n){
      if (x%i==0 &&(x/i)<=n) {
     
       c++;
      }
      i++;
       }
       System.out.println(c);
  }
        }
 
 
