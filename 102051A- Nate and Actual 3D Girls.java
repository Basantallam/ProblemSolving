import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
 
public class NateandActual3DGirls {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		int[] freq = new int[26];
		
		for (int i = 0; i < n; i++) {
			String x = sc.next();
			
			for (int j = 0; j < x.length(); j++) {
				//System.out.println(x.charAt(j)+0);
				freq[x.charAt(j) - 97]++;
			}
			
		}
//		System.out.println(Arrays.toString(freq));
		
		for (int i = 0; i < m; i++) {
			String x = sc.next();
			
			for (int j = 0; j < x.length(); j++) {
				int c=(x.charAt(j)-97+k)%26;
 
				if (freq[c] > 0)
					freq[c]--;
				else {
					System.out.println("It is gonna be daijoubu.");
					return;
				}
			}
 
		}
 
 
		System.out.println("Make her kokoro go doki-doki!");
	}
 
}
