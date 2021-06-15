import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class VanyaandLanterns {
 
 public static void main(String[] args) throws IOException {
 
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  StringTokenizer st = new StringTokenizer(br.readLine());
  int n = Integer.parseInt(st.nextToken());
  int l = Integer.parseInt(st.nextToken());
  st = new StringTokenizer(br.readLine());
  int[] arr = new int[n];
  for (int i = 0; i < n; i++) {
   arr[i] = Integer.parseInt(st.nextToken());
  }
  Arrays.sort(arr);
  double max = arr[0];
  for (int i = 0; i < n - 1; i++) {
   max = Math.max((arr[i + 1] - arr[i])/2.0, max);
  }
  max = Math.max(max, (l - arr[n - 1]));
  System.out.println(String.format("%.10f", max));
 }
 
}
