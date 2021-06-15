import java.util.Arrays;
import java.util.Scanner;
 
public class Message {
 
 public static void main(String[] args) {
  Scanner sc=new Scanner(System.in);
  String a=sc.next();
  String b=sc.next();
  int maxlen=Math.max(a.length(), b.length());
  int minlen=Math.min(a.length(), b.length());
  
  char[] s=new char [maxlen];
  char[] m=new char [maxlen];
  for(int i=0;i<a.length();i++) {
   s[i]=a.charAt(i);
  }
  for(int i=0;i<b.length();i++) {
   m[i]=b.charAt(i);
  }
  
  int shifts=a.length()+b.length()-1;
  
//  System.out.println(Arrays.toString(s));
//  System.out.println(Arrays.toString(m));
  int atshift=0;
  int maxsim=0;
  
  for(int shift=-b.length();shift<maxlen;shift++) {
//   System.out.println("shift "+shift);
   int similarity=0;
   inner: for(int i=0;i<maxlen;i++) {
//    System.out.println(i+" "+(i+shift));
    if (i<0||i>maxlen||i+shift<0||i+shift>=s.length)
     continue inner;
    
    if(s[i+shift]==m[i]) {
     similarity++;
    }
   }
   
   if(maxsim<similarity) {
    atshift=shift;
    maxsim=similarity;
   }
//   System.out.println("similarity "+similarity);
  }
//  System.out.println(atshift+" "+maxsim);
  
   System.out.println(b.length()-maxsim);
 
  }
 }
 
 
