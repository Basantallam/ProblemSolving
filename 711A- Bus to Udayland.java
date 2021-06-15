import java.util.*;
public class Main{
   
  public static void main(String[] args)
   {
    Scanner sc= new Scanner(System.in);
    int n=sc.nextInt();
    boolean f=false;
    String [] s=new String[n];
    for(int i=0;i<n;i++) {
    s[i]=sc.next();
     
    }
    for(int i=0;i<n;i++) {
       if((s[i].substring(0,2)).equals("OO")) {
        f=true;
        s[i]="++"+s[i].substring(2,5);
        break;  
       }
       if(s[i].substring(3,5).equals("OO") ) {
        f=true;
        s[i]=s[i].substring(0,3)+"++";
        break;
       }
    }
    if(f) {
     System.out.println("YES");
     for(int i=0;i<n;i++) {
     System.out.println(s[i]);
       
      }}
     else {
      System.out.println("NO");
     
    }
   }
     
 }
