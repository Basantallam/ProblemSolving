import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;
 
public class ProductOfThreeNumbers {
 static ArrayList<pair> ll;
 static ArrayList<pair> ll2;
 public static void main(String[] args) throws Exception {
  Scanner sc = new Scanner(System.in);
  PrintWriter out = new PrintWriter(System.out);
  
  int t = sc.nextInt();
  for(int j=0 ; j<t ; j++) {
   
   int n = sc.nextInt();
   ll = new ArrayList<>();
   divi(n);
//   for(pair p :ll) {
//    System.out.println(p.x +" " +p.y);
//   }
   if(ll.size()==0) {
    //System.out.println("in");
    System.out.println("NO");
   }
   else {
    int a=0;
    int b=0;
    int c=0;
    boolean YES = false;
    for(int i=0; i<ll.size() ; i++) {
     a = ll.get(i).x;
     int y = ll.get(i).y;
     ll2 = new ArrayList<>();
     divi2(y);
     if(ll2.size()>=1) {
      for(int k=0 ; k<ll2.size() ;k++) {
       b = ll2.get(0).x;
       c = ll2.get(0).y;
       if(b!=a && c!=a) {
        YES = true;
        break;
       }
      }
      if(YES)
       break;
     }
    }
    if(YES && a >=2 && b>=2 && c>=2) {
     System.out.println("YES");
     System.out.println(a+" "+b +" "+c);
    }
    else {
     System.out.println("NO");
    }
    
   }
   
  }
  
  
 }
 public static void divi(int n) {
  for(int i=2; i*i<n ; i++) {
   if(n%i==0) {
    int j = n/i;
    if(i!=j)
     ll.add(new pair(i,j));
   }
  }
 }
 public static void divi2(int n) {
  for(int i=2; i*i<n ; i++) {
   if(n%i==0) {
    int j = n/i;
    if(i!=j)
     ll2.add(new pair(i,j));
   }
  }
 }
 
 static class pair{
  int x;
  int y;
  
  public pair(int x, int y) {
   this.x = x;
   this.y = y;
  }
 }
 
 
 static class Scanner {
  StringTokenizer st; 
  BufferedReader br;
 
  public Scanner(InputStream system) {
   br = new BufferedReader(new InputStreamReader(system));
  }
 
  public Scanner(String file) throws Exception {
   br = new BufferedReader(new FileReader(file));
  }
 
  public String next() throws IOException {
   while (st == null || !st.hasMoreTokens())
    st = new StringTokenizer(br.readLine());
   return st.nextToken();
  }
 
  public String nextLine() throws IOException {
   return br.readLine();
  }
 
  public int nextInt() throws IOException {
   return Integer.parseInt(next());
  }
 
  public double nextDouble() throws IOException {
   return Double.parseDouble(next());
  }
 
  public char nextChar() throws IOException {
   return next().charAt(0);
  }
 
  public Long nextLong() throws IOException {
   return Long.parseLong(next());
  }
 
  public boolean ready() throws IOException {
   return br.ready();
  }
 
  public void waitForInput() throws InterruptedException {
   Thread.sleep(3000);
  }
 }
}
