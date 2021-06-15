import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
  public static void main(String[] args) throws IOException {
    Scanner sc=new Scanner(System.in);
    long c=sc.nextLong(); // ax^2 +bx-c=0 (a=1) (b=s(x) (c=input)
    boolean printed=false;
    for(int b=0;b<=81;b++) {
     long sqrt=sqrt(b*b +4*c);
     if(sqrt!=-1 ) {
        if((-b-sqrt)%2==0 &&(-b-sqrt)>0)  {
         long x=(-b-sqrt)/2;
         if(x*x + s(x)*x==c ) {
          System.out.println(x);
          printed=true;
          break;
         }
        }
         if((-b+sqrt)%2==0 &&(-b+sqrt)>0)  {
          long x=(-b+sqrt)/2;
          if(x*x + s(x)*x==c ) {
           System.out.println(x);
           printed=true;
           break;
          }
        }
     }
  
    }
    
       if(!printed)
     System.out.println("-1");
  
    
  }
  public static long s(long n) {
     int sum=0;
     while(n!=0) {
      int temp=(int) n%10;
      n/=10;
      sum+=temp;
     }
     return sum;
    }
  public static long sqrt(long n) {
   
   if(n>=0)
    return (long)Math.sqrt(n);
   else return -1;
  }
  
 static class Scanner 
 {
     StringTokenizer st;
     BufferedReader br;
 
     public Scanner(InputStream s){    br = new BufferedReader(new InputStreamReader(s));}
 
     public String next() throws IOException 
     {
         while (st == null || !st.hasMoreTokens()) 
             st = new StringTokenizer(br.readLine());
         return st.nextToken();
     }
 
     public int nextInt() throws IOException {return Integer.parseInt(next());}
     
     public long nextLong() throws IOException {return Long.parseLong(next());}
 
     public String nextLine() throws IOException {return br.readLine();}
     
     public double nextDouble() throws IOException
     {
         String x = next();
         StringBuilder sb = new StringBuilder("0");
         double res = 0, f = 1;
         boolean dec = false, neg = false;
         int start = 0;
         if(x.charAt(0) == '-')
         {
             neg = true;
             start++;
         }
         for(int i = start; i < x.length(); i++)
             if(x.charAt(i) == '.')
             {
                 res = Long.parseLong(sb.toString());
                 sb = new StringBuilder("0");
                 dec = true;
             }
             else
             {
                 sb.append(x.charAt(i));
                 if(dec)
                     f *= 10;
             }
         res += Long.parseLong(sb.toString()) / f;
         return res * (neg?-1:1);
     }
     
     public boolean ready() throws IOException {return br.ready();}
 
 
 }
}
