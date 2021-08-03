import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MahmoudAndEhabAndTheBipartiteness { //Observation based solution 
    static boolean visited[];
    static ArrayList<Integer> adjList [];
    static long Odd=0;
    static long Even=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        visited = new boolean[n];
        adjList = new ArrayList[n];

        for (int i = 0; i < n; i++)
            adjList[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adjList[u - 1].add(v - 1);
            adjList[v - 1].add(u - 1);
        }
        dfs(0, true);

        System.out.println(Even * Odd - n + 1);
    }

    public static void dfs(int u, boolean odd){
        visited[u]=true;
        if (odd) Odd++;
        else Even++;
        for(int v:adjList[u])
            if(!visited[v])
                dfs(v, !odd);
    }
}
