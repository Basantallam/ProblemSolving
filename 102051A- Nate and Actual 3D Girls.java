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
		int[] el7roof = new int[26];
		
		for (int i = 0; i < n; i++) {
			String x = sc.next();
			
			for (int j = 0; j < x.length(); j++) {
				//System.out.println(x.charAt(j)+0);
				el7roof[x.charAt(j) - 97]++;
			}
			
		}
//		System.out.println(Arrays.toString(el7roof));
		
		for (int i = 0; i < m; i++) {
			String x = sc.next();
			
			for (int j = 0; j < x.length(); j++) {
				int c=(x.charAt(j)-97+k)%26;
 
				if (el7roof[c] > 0)
					el7roof[c]--;
				else {
					System.out.println("It is gonna be daijoubu.");
					return;
				}
			}
 
		}
 
 
		System.out.println("Make her kokoro go doki-doki!");
	}
 
}