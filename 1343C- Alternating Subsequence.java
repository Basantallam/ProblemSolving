import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.StringTokenizer;
 
public class AlternatingSubsequence {
 
 
    public static void main(String[] args) throws IOException {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        while (t-- > 0) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            long[] arr = new long[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            long maxSum = 0;
            boolean pos = arr[0] > 0;
            long maxPos = pos ? arr[0] : 0;
            long minNeg = pos ? (int)-1e9 : arr[0];
            for (int i = 0; i < N; i++) {
                if (pos) {
                    if (arr[i] < 0) {
                        maxSum += maxPos;
                        maxPos=0;
                        pos = false;
                        minNeg = arr[i];
                        if (i == N - 1) maxSum += minNeg;
                    } else {
                        maxPos = Math.max(maxPos, arr[i]);
                        if (i == N - 1) maxSum += maxPos;
                    }
                }
                else if (!pos) {
                    if (arr[i] > 0) {
                        maxSum += minNeg;
                        minNeg=(int)-1e9;
                        pos = true;
                        maxPos = arr[i];
 
                        if (i == N - 1) maxSum += maxPos;
                    } else {
                        minNeg = Math.max(minNeg, arr[i]);
                        if (i == N - 1) maxSum += minNeg;
 
                    }
                }
            }
            System.out.println(maxSum);
 
        }
 
    }
}
 
 
