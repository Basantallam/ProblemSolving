import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class CircularRMQ {
 static SegmentTree tree;
 static int N;
 static int n;
 
 public static void main(String[] args) throws IOException {
  StringTokenizer st;
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  PrintWriter pw=new PrintWriter(System.out);
  st = new StringTokenizer(br.readLine());
  n = Integer.parseInt(st.nextToken());
 
  N = 1;
  while (N < n)
   N <<= 1;
 
  long[] in = new long[N + 1];
//  Arrays.fill(in, Long.MAX_VALUE);
  st = new StringTokenizer(br.readLine());
 
  for (int i = 1; i <= n; i++)
   in[i] = Integer.parseInt(st.nextToken());
 
  tree = new SegmentTree(in);
  st = new StringTokenizer(br.readLine());
 
  int m = Integer.parseInt(st.nextToken());
 
  for (int i = 0; i < m; i++) {
   st = new StringTokenizer(br.readLine());
   if (2 == st.countTokens()) {
    int l = Integer.parseInt(st.nextToken()) + 1;
    int r = Integer.parseInt(st.nextToken()) + 1;
    pw.println(rmq(l, r));
   } else {
    int l = Integer.parseInt(st.nextToken()) + 1;
    int r = Integer.parseInt(st.nextToken()) + 1;
    int v = Integer.parseInt(st.nextToken());
    inc(l, r, v);
   }
 
  }
 
  pw.flush();
 }
 
 public static void inc(int l, int r, int v) {
  if (l <= r)
   tree.update_range(l, r, v);
  else {
   tree.update_range(1, r, v);
   tree.update_range(l, n, v);
//   System.out.println("1 to " + r + " " + l + " to " + n);
  }
 }
 
 public static long rmq(int l, int r) {
  long q = 0;
  if (l <= r)
   q = tree.query(l, r);
  else
   q = Math.min(tree.query(1, r), tree.query(l, n));
 
  return q;
 }
 
 static class SegmentTree {
 
  int N;
  long[] array, sTree, lazy;
 
  SegmentTree(long[] in) {
   array = in;
   N = in.length - 1;
   sTree = new long[N << 1]; // big array akher N elements mnha homa in[]
   lazy = new long[N << 1];
   build(1, 1, N);
  }
 
  void build(int node, int b, int e) {
   if (b == e)
    sTree[node] = array[b];
   else {
    int mid = b + e >> 1;
    build(node << 1, b, mid);
    build(node << 1 | 1, mid + 1, e);
    sTree[node] = Math.min(sTree[node << 1], sTree[node << 1 | 1]);
   }
  }
 
  void update_range(int i, int j, int val) {
   update_range(1, 1, N, i, j, val);
  }
 
  void update_range(int node, int b, int e, int i, int j, int val) {
   if (i > e || j < b)
    return;
 
   if (b >= i && e <= j) {
    sTree[node] += val;
    lazy[node] += val;
   } else {
    int mid = b + e >> 1;
    propagate(node, b, mid, e);
    update_range(node << 1, b, mid, i, j, val);
    update_range(node << 1 | 1, mid + 1, e, i, j, val);
    sTree[node] = Math.min(sTree[node << 1], sTree[node << 1 | 1]);
   }
 
  }
 
  void propagate(int node, int b, int mid, int e) {
   lazy[node << 1] += lazy[node];
   lazy[node << 1 | 1] += lazy[node];
   sTree[node << 1] += lazy[node];
   sTree[node << 1 | 1] += lazy[node];
   lazy[node] = 0;
  }
 
  long query(int i, int j) {
   return query(1, 1, N, i, j);
  }
 
  long query(int node, int b, int e, int i, int j) {
   if (i > e || j < b)
    return Long.MAX_VALUE;
 
   if (b >= i && e <= j)
    return sTree[node];
 
   int mid = b + e >> 1;
   propagate(node, b, mid, e);
   long q1 = query(node << 1, b, mid, i, j);
   long q2 = query(node << 1 | 1, mid + 1, e, i, j);
   return Math.min(q1, q2);
 
  }
 
 }
 
}
