import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ValidSets {
    static ArrayList<Integer> adjList[];
    static int a[];
    static int d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        d = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        a = new int[n];
        adjList = new ArrayList[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            adjList[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adjList[x - 1].add(y - 1);
            adjList[y - 1].add(x - 1);
        }
        long count=0;
        for(int i=0;i<n;i++){
            count+=dpDFS(i, -1, i);
            count=count%1000000007;
        }
        System.out.println(count);
    }

    public static long dpDFS(int u, int p, int max) {

        long res = 1;


        for (int v : adjList[u]) {

            if (p == v) continue;
            if(a[v]>a[max]) continue;
            if(Math.abs(a[max]-a[v])>d) continue;
            if(max<v && a[max]==a[v]) continue;

            res *= (1 + dpDFS(v, u, max));

            res=res%1000000007;
        }

        return res%1000000007;
    }
}
