import java.util.Arrays;
import java.util.Scanner;
 
public class SpreadSheet {
 
 public static void main(String[] args) {
 
  Scanner sc=new Scanner(System.in);
  int n=sc.nextInt();
  
  while(n-->0) {
   
   String s=sc.next();
   StringBuilder r=new StringBuilder("");
   int c;
   int p;
      int[] arr;
   if(!System2(s)) { //R..C
//    System.out.println("system 1");
    int i;
    for(i=1;i<s.length() && s.charAt(i)!='C';i++){
     r.append(s.charAt(i));
    }
    
    c=Integer.parseInt(s.substring(++i));
       p=(int)(Math.log(c)/Math.log(26));
       arr=new int[p+1];
       boolean zero=false;
    while(p>=0) {
     arr[p]=c/(int)Math.pow(26,p); 
     zero=arr[p]==0;
     
     c=c%(int)Math.pow(26,p);
     p--;
    }
//    System.out.print(Arrays.toString(arr));
    arr=getridofzeroes(arr);
    for(int i1=arr.length-1;i1>=0 ;i1--) {
     if(arr[i1]==0)
      continue;
     System.out.print((char)(arr[i1]+'A'-1));
    }
    
    System.out.print(r);
    System.out.println();
   }
   else {
    String cc;
    int i;
    for(i=0;i<s.length()&&s.charAt(i)<='Z'&&s.charAt(i)>='A';i++) {
     r.append(s.charAt(i));
    }
    cc=r+"";
    c=Integer.parseInt(s.substring(i));
    int col=0;
    p=0;
    while(!cc.isEmpty()){
     col+=(cc.charAt(cc.length()-1)-'A'+1)*(int)Math.pow(26,p);
     cc=cc.substring(0, cc.length()-1);
     p++;
    }
    System.out.println("R"+c+"C"+col);
   }
  }
 }
 
 public static int[] getridofzeroes(int[] arr) {
  for(int i=0;i<arr.length;i++) {
   if(arr[i]<=0 && i<arr.length-1) {
    arr[i]+=26;
    arr[i+1]--;
   }
  }
//  System.out.println(Arrays.toString(arr));
  return arr;
 }
 
 public static boolean System2(String s) {
  boolean letters=true;
  
  for(int i=0;i<s.length();i++) {
   if(s.charAt(i)>='A'&&s.charAt(i)<='Z') {
    if(!letters)
     return false;
   }
   else
    letters=false;
   
  }
  return true;
 }
 
}
