import java.util.Scanner;
 
public class TwoButtons {
 
 static int f;
 static int t;
  public static void main(String args[]) {
 Scanner sc=new Scanner(System.in);
  f=sc.nextInt();
  t=sc.nextInt();
     System.out.println(rec(f,t));
 
 
  }
  
public static int rec(int f, int t) {
 if(f>=t)
  return f-t;
 if(t%2==0)
  return rec(f,t/2)+1 ;
 else
  return rec(f,t+1)+1;
 
}
 
}
