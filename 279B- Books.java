import java.util.Scanner;
 
public class Books3 {
 
 public static void main(String[] args) {// same problem third solution
 
  Scanner sc = new Scanner(System.in);
  int b = sc.nextInt();
  int t = sc.nextInt();
  int[] arr = new int[b];
  for (int i = 0; i < b; i++) {
   arr[i] = sc.nextInt();
  }
  int maxlen = 0;
  int len = 0;
 
  int ptr1 = 0;
  int ptr2 = -1;
  int cursum = 0;
 
  while (ptr2 < b - 1) {
   while (ptr2 < b - 1 && cursum <= t) {
    ptr2++;
    cursum += arr[ptr2];
    len++;
//    System.out.println(ptr1 + " " + ptr2 + " " + len+ " "+ cursum);
    if (cursum <= t)
     maxlen = Math.max(maxlen, len);
   }
//   System.out.println(maxlen);
//   System.out.println("stuck "+ptr1 + " " + ptr2 + " " + len+" "+cursum);
   while (cursum > t && ptr1 <= ptr2) {
    cursum -= arr[ptr1];
    ptr1++;
    len--;
    if (cursum <= t)
     maxlen = Math.max(maxlen, len);
//    System.out.println(ptr1 + " " + ptr2 + " " + len+ " "+cursum);
   }
//   System.out.println(maxlen);
  }
  System.out.println(maxlen);
 }
 
}
