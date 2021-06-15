import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Reorder {
 
 public static void main(String[] args) throws IOException {
 
  Scanner sc=new Scanner(System.in);
  int t=sc.nextInt();
  
  while(t-->0){
    int n=sc.nextInt();
    int m=sc.nextInt();
   int ans=0;
   for(int i=0;i<n;i++) {
    ans+=sc.nextInt();
    
   }
   System.out.println(ans==m?"YES":"NO");
  }
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
 
 }
 
}
