import java.util.*;
public class Main{
 public static void main(String[] args)
   { 
  Scanner sc=new Scanner(System.in);
  int x1=sc.nextInt();
  int y1=sc.nextInt();
     int x2=sc.nextInt();
     int y2=sc.nextInt();
     int dx=x1-x2;
     int dy=y1-y2;
     String s="";
     
    if(dx==0) {
     System.out.println((x1+dy) +" "+y1+ " "+(x2+dy)+" "+y2);
    }else {
     if(dy==0) {
      System.out.println(x1 +" "+(y1+dx)+ " "+x2+" "+(y2+dx));
 
     }else
      
     if(Math.abs(dx)!=Math.abs(dy)) {
      System.out.println(-1);
     }
     else {
      System.out.println(x1+" "+y2+" "+x2+" "+y1);
     }
    }
   }
}
