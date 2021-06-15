import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class NiceMatrix {
 static int n;
 static int m;
 
 public static void main(String[] args) throws IOException {
  Scanner sc = new Scanner(System.in);
  int t = sc.nextInt();
  while (t-- > 0) {
   n = sc.nextInt();
   m = sc.nextInt();
   long[][] matrix = new long[n][m];
 
   for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
     matrix[i][j] = sc.nextLong();
    }
   }
   long ans = 0;
   for (int i = 0; i < n / 2; i++) {
    for (int j = 0; j < m / 2; j++) {
     ans += binarySearch(matrix[i][j], matrix[n - i - 1][j], matrix[i][m - j - 1],
       matrix[n - i - 1][m - j - 1]);
    }
   }
   if (n % 2 != 0) {
    for (int j = 0; j < m / 2; j++) {
     ans += Math.abs(matrix[(n / 2 + 1) - 1][j] - matrix[(n / 2 + 1) - 1][m - 1 - j]);
//     System.out.println(matrix[(n / 2 + 1) - 1][j] + " " + matrix[(n / 2 + 1) - 1][m - 1 - j]);
    }
   }
 
   if (m % 2 != 0) {
    for (int i = 0; i < n / 2; i++)
     ans += Math.abs(matrix[i][(m / 2 + 1) - 1] - matrix[n - 1 - i][(m / 2 + 1) - 1]);
   }
   System.out.println(ans);
  }
 }
 
 public static long binarySearch(long a, long b, long c, long d) {
 
  long hi = Math.max(Math.max(a, b), Math.max(c, d));
  long lo = Math.min(Math.min(a, b), Math.min(c, d));
  long min = Long.MAX_VALUE;
  
  while (hi > lo) {
   long mid = (hi + lo) / 2;
 
//   min = Math.min(calc(mid, a, b, c, d), min);
   min = Math.min(calc(hi, a, b, c, d), min);
   min = Math.min(calc(lo, a, b, c, d), min);
   
   if (calc((mid + hi) / 2, a, b, c, d) < calc((mid + lo) / 2, a, b, c, d)) {
//    min = Math.min(calc((mid + hi) / 2, a, b, c, d), min);
    lo = mid;
   } else {
//    min = Math.min(calc((mid + lo) / 2, a, b, c, d), min);
    hi = mid;
   }
  }
  
  if (min == Long.MAX_VALUE) 
   min = 0;
  
  return min;
 
 }
 
 public static long calc(long mid, long a, long b, long c, long d) {
  return Math.abs(mid - a) + Math.abs(mid - b) + Math.abs(mid - c) + Math.abs(mid - d);
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
 
  public long nextLong() throws IOException {
   return Long.parseLong(next());
  }
 
  public int nextInt() throws IOException {
   return Integer.parseInt(next());
  }
 
 }
}
