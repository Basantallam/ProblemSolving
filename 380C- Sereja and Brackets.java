import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class SerejaandBrackets2 {
 static final int INF = (int) 1e7;
 static int n;
 static int ans = 0;
 
 public static void main(String[] args) throws IOException {
 
  Scanner sc = new Scanner(System.in);
  PrintWriter pw = new PrintWriter(System.out);
 
  String s = sc.next();
  n = s.length();
 
  int N = 1;
  while (N < n)
   N <<= 1; // padding
 
  char[] in = new char[N + 1];
 
  for (int i = 0; i < s.length(); i++)
   in[i + 1] = s.charAt(i);
  SegmentTree st = new SegmentTree(in);
 
  int q = sc.nextInt();
  while (q-- > 0) {
   ans = 0;
   int l = sc.nextInt();
   int r = sc.nextInt();
   
   pw.println(st.query(l, r).len);
  }
  pw.flush();
  pw.close();
 }
 
 static class Node {
 
  int remopen;
  int remclosed;
  int len = 0;
 
  public Node() {
 
  }
 
//  public String toString() {
//   return "ro " + remopen + " rc " + remclosed + " len " + len;
//  }
 
 }
 
 static class SegmentTree { // 1-based DS, OOP
 
  int N; // the number of elements in the array as a power of 2 (i.e. after padding)
  char[] array;
  Node[] sTree;
 
  SegmentTree(char[] in) {
   array = in;
   N = in.length - 1;
   sTree = new Node[N << 1]; // no. of nodes = 2*N - 1, we add one to cross out index zero
 
   for (int i = 0; i < (N << 1); i++) {
    sTree[i] = new Node();
 
   }
   build(1, 1, N);
  }
 
  void build(int node, int b, int e) // O(n)
  {
   if (b == e) {
    if (array[b] == ')')
     sTree[node].remopen = 1;
    else
     sTree[node].remclosed = 1;
   } else {
 
    int mid = b + e >> 1;
    build(node << 1, b, mid);
    build(node << 1 | 1, mid + 1, e);
 
    
    sTree[node].len = sTree[node << 1].len + sTree[node << 1 | 1].len
      + 2 * Math.min(sTree[node << 1].remclosed, sTree[node << 1 | 1].remopen);
    sTree[node].remclosed = sTree[node << 1].remclosed + sTree[node << 1 | 1].remclosed
      - Math.min(sTree[node << 1].remclosed, sTree[node << 1 | 1].remopen);
    sTree[node].remopen = sTree[node << 1].remopen + sTree[node << 1 | 1].remopen
      - Math.min(sTree[node << 1].remclosed, sTree[node << 1 | 1].remopen);
   }
  }
 
  Node query(int i, int j) {
   return query(1, 1, N, i, j);
  }
 
  Node query(int node, int b, int e, int i, int j) // O(log n)
  {
   if (i > e || j < b) {
    return new Node();
   }
   if (b >= i && e <= j) {
    return sTree[node];
   }
 
   int mid = b + e >> 1;
   Node q1 = query(node << 1, b, mid, i, j);
 
   Node q2 = query(node << 1 | 1, mid + 1, e, i, j);
   
   
   ans= q1.len + q2.len+2*Math.min(q1.remclosed, q2.remopen);
   Node temp = new Node();
   temp.len=ans;
   temp.remclosed=q1.remclosed+q2.remclosed-Math.min(q1.remclosed, q2.remopen);
   temp.remopen=q1.remopen+q2.remopen-Math.min(q1.remclosed, q2.remopen);
   return temp;
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
 
 }
}
