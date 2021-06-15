import java.util.*;
public class Main{
 public static void main(String[] args)
   { 
  Scanner sc=new Scanner(System.in);
  int t=sc.nextInt();
  for(int j=0;j<t;j++) {
  String s=sc.next();
  
  String s2a="";
  String s2b="";
  String s3a="";
  String s3b="";
  String s3c="";
  String s4a="";
  String s4b="";
  String s4c="";
  String s4d="";
  String s6a="";
  String s6b="";
  String s6c="";
  String s6d="";
  String s6e="";
  String s6f="";
  String sol="";
  
  int ways=0;
  if(s.contains("X")) {
   ways++;
   sol+="1x12 ";
  }
  
  for(int i=0;i<7;i+=6) {
   s6a+=s.charAt(i);
   s6b+=s.charAt(i+1);
   s6c+=s.charAt(i+2);
   s6d+=s.charAt(i+3);
   s6e+=s.charAt(i+4);
   s6f+=s.charAt(i+5);
  }
  if(!s6a.contains("O")||!s6b.contains("O")||!s6c.contains("O")||!s6d.contains("O")||!s6e.contains("O")||!s6f.contains("O")) {
   ways++;
   sol+="2x6 ";
  }
 
  
  for(int i=0;i<9;i+=4) {
   s4a+=s.charAt(i);
   s4b+=s.charAt(i+1);
   s4c+=s.charAt(i+2);
   s4d+=s.charAt(i+3);
   
  }
  if(!s4a.contains("O")||!s4b.contains("O")||!s4c.contains("O")||!s4d.contains("O")) {
   ways++;
   sol+="3x4 ";
  } 
  for(int i=0;i<10;i+=3) {
   s3a+=s.charAt(i);
   s3b+=s.charAt(i+1);
   s3c+=s.charAt(i+2);
  }
  
  if(!s3a.contains("O")||!s3b.contains("O")||!s3c.contains("O")) {
   ways++;
   sol+="4x3 ";
  }
  for(int i=0;i<11;i+=2) {
   s2a+=s.charAt(i);
   s2b+=s.charAt(i+1);
  }
  if(!s2a.contains("O")||!s2b.contains("O")) {
   ways++;
   sol+="6x2 ";
  }
  
  if(!s.contains("O")) {
   ways++;
      sol+="12x1 ";
      }
  System.out.println(ways+" "+sol);
 }
   }
}
