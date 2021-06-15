import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
 
public class XeniaandBitOperations {
 static int temp;
 
 public static void main(String[] args) throws IOException {
 
  Scanner sc = new Scanner(System.in);
  PrintWriter pw = new PrintWriter(System.out);
  int n = sc.nextInt();
  temp = n;
  n = (int) Math.pow(2, n);
  int m = sc.nextInt();
 
  int N = 1;
  while (N < n)
   N = N << 1; // padding
 
  long[] in = new long[N + 1];
  for (int i = 1; i <= n; i++)
   in[i] = sc.nextLong();
 
  SegmentTree st = new SegmentTree(in);
  for (int i = 0; i < m; i++) {
 
   st.update_point(sc.nextInt(), sc.nextLong());
   pw.println(st.query());
  }
  pw.flush();
  pw.close();
 }
 
 static class SegmentTree { // 1-based DS, OOP
 
  int N; // the number of elements in the array as a power of 2 (i.e. after padding)
  long[] array, sTree, lazy;
 
  SegmentTree(long[] in) {
   array = in;
   N = in.length - 1;
   sTree = new long[N << 1]; // no. of nodes = 2*N - 1, we add one to cross out index zero
   lazy = new long[N << 1];
   build(1, 1, N,temp%2==0?true:false);
  }
 
  void build(int node, int b, int e, boolean XOR) // O(n)
  {
   if (b == e)
    sTree[node] = array[b];
   else {
    int mid = b + e >> 1;
    build(node << 1, b, mid, !XOR);
    build(node << 1 | 1, mid + 1, e, !XOR);
    sTree[node] = XOR ? sTree[node << 1] ^ sTree[node << 1 | 1] : sTree[node << 1] | sTree[node << 1 | 1];
 
   }
  }
 
  void update_point(int index, long val) // O(log n)
  {
   index += N - 1;
   sTree[index] = val;
   boolean XOR = false;
   while (index > 1) {
    index >>= 1;
    sTree[index] = XOR ? sTree[index << 1] ^ sTree[index << 1 | 1]
      : sTree[index << 1] | sTree[index << 1 | 1];
    XOR = !XOR;
   }
  }
 
  long query() {
   return sTree[1];
  }
 
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
 
  public long nextLong() throws IOException {
   return Long.parseLong(next());
  }
 
 }
}
