import java.util.*;
public class Main{
   
  public static void main(String[] args)
   {
    Scanner sc= new Scanner(System.in);
    int n=sc.nextInt();
    int k=sc.nextInt();
    int [] s=new int[n];
    for(int i=0;i<n;i++) {
    s[i]=sc.nextInt();
     
    }
 
    int c=0;
    int p=s[k-1];
    while( c<n && s[c]>=p && s[c]>0 ) {
 
    
    c++;
    }
    System.out.println(c);
   }
  
  
     
 }
