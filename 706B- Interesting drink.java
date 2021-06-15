import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class InterestingDrink {
 static int[] arr;
 
 public static void main(String[] args) throws IOException {
 
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  StringTokenizer st = new StringTokenizer(br.readLine());
 
  int n = Integer.parseInt(st.nextToken());
  arr = new int[n];
 
  st = new StringTokenizer(br.readLine());
  for (int i = 0; i < n; i++) {
   arr[i] = Integer.parseInt(st.nextToken());
  }
  st = new StringTokenizer(br.readLine());
// 3 6 8 10 11
  int days = Integer.parseInt(st.nextToken());
 
  int[] coinsADay = new int[days];
  for (int i = 0; i < days; i++) {
   st = new StringTokenizer(br.readLine());
   coinsADay[i] = Integer.parseInt(st.nextToken());
  }
  Arrays.sort(arr);
  for (int i = 0; i < days; i++) {
   if (arr[0] > coinsADay[i]) {
    System.out.println(0);
   } else
   System.out.println(binarySearch(n - 1, 0, coinsADay[i]) + 1);
  }
 
 }
 
 public static int binarySearch(int hi, int lo, int target) {
  int mid = (hi + lo + 1) / 2;
  if (lo >= hi)
   return lo;
  if (ok(target, arr[mid])) {
   return binarySearch(hi, mid, target);
  } else {
   return binarySearch(mid - 1, lo, target);
 
  }
 }
 
 public static boolean ok(int target, int curr) {
  return curr <= target;
 }
 
}
