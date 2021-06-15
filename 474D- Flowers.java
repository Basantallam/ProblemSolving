import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Flowers {
 static int k;
 static long dpmemo[];
 static int N;
 public static void main(String[] args) throws IOException {
 
  Scanner sc = new Scanner(System.in);
  int t = sc.nextInt();
  k = sc.nextInt();
 
  PrintWriter pw = new PrintWriter(System.out);
 
  int n = 100000;
   N = 1; while(N < n) N <<= 1; //padding
  
  dpmemo = new long[N + 1];
  Arrays.fill(dpmemo, -1);
  
  
  for (int i = 0; i < 100001; i++) {
   dp(i);
  }
  
  SegmentTree st=new SegmentTree(dpmemo);
  
  while (t -- > 0) {
 
   int a = sc.nextInt();
   int b = sc.nextInt();
   long q=st.query(a, b);
 
 
   pw.println(q);
  }
 
  pw.flush();
 }
 
 public static long dp(int remlen) {
 
  if (remlen == 0)
   return 1;
 
  if (remlen < 0)
   return 0;
 
  if (dpmemo[remlen] != -1)
   return dpmemo[remlen];
  
  long dp1 = dp(remlen - 1) % 1000000007;
  long dp2 = dp(remlen - k) % 1000000007;
  long sum = dp1 + dp2;
  sum = sum % 1000000007;
  return dpmemo[remlen] = sum;
 
 }
 
 static class Scanner {
  StringTokenizer st;
  BufferedReader br;
 
  public Scanner(InputStream s) {
   br = new BufferedReader(new InputStreamReader(s));
  }
 
  public String next() throws IOException {
   while (st == null || !st.hasMoreTokens())
    st = new StringTokenizer(br.readLine());
   return st.nextToken();
  }
 
  public int nextInt() throws IOException {
   return Integer.parseInt(next());
  }
 }
 
 // Range Sum Query (with lazy propagation)
 
 static class SegmentTree {  // 1-based DS, OOP
  
     //the number of elements in the array as a power of 2 (i.e. after padding)
  long[] array, sTree, lazy;
  
  SegmentTree(long[] in)  
  {
   array = in; N = in.length - 1;
   sTree = new long[N<<1];  //no. of nodes = 2*N - 1, we add one to cross out index zero
   lazy = new long[N<<1];
   build(1,1,N);
  }
  
  void build(int node, int b, int e) // O(n)
  {
   if(b == e)     
    sTree[node] = array[b];
   else      
   {
    int mid = b + e >> 1;
    build(node<<1,b,mid);
    build(node<<1|1,mid+1,e);
    sTree[node] = sTree[node<<1]+sTree[node<<1|1];
   }
  }
  
  
  void propagate(int node, int b, int mid, int e)  
  {
   lazy[node<<1] += lazy[node];
   lazy[node<<1|1] += lazy[node];
   sTree[node<<1] += (mid-b+1)*lazy[node];  
   sTree[node<<1|1] += (e-mid)*lazy[node];  
   lazy[node] = 0;
  }
  
  long query(int i, int j)
  {
   return query(1,1,N,i,j);
  }
  
  long query(int node, int b, int e, int i, int j) // O(log n)
  {
   if(i>e || j <b)
    return 0;  
   if(b>= i && e <= j)
    return sTree[node];
   int mid = b + e >> 1;
   propagate(node, b, mid, e);
   long q1 = query(node<<1,b,mid,i,j)%1000000007;
   long q2 = query(node<<1|1,mid+1,e,i,j)%1000000007;
   return (q1 + q2)%1000000007; 
     
  }
  
  
  
 }
}
