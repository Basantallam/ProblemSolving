
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class ConnectedComponents {
    static int n;
    static int size=0;
    static PrintWriter pw;
    static LinkedList <Integer>ll=new LinkedList<>();
    static int V;   // No. of vertices
    static Set<Integer> adj[]; //Adjacency List
    public static void main(String args[]) throws IOException {
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        adj = new HashSet[n];
        for (int i=0; i<n; ++i)
            adj[i] = new HashSet();
        int m = Integer.parseInt(st.nextToken());

        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            adj[a-1].add(b-1);
            adj[b-1].add(a-1);
        }

        pw = new PrintWriter(System.out);
        printSCCs();
        Collections.sort(ll);
        for(int x:ll)
            pw.print(x+" ");
        pw.flush();
    }

        static void DFS(int u,TreeSet<Integer> unvisited)
        {
            unvisited.remove(u);
            size++;
            int curr=0;
            while(!unvisited.isEmpty() && curr<=unvisited.last()){
                curr=unvisited.ceiling(curr);
                if (!adj[u].contains(curr))
                    DFS(curr,unvisited);
                curr++;
            }
        }

        static void printSCCs()
        {
            TreeSet<Integer> unvisited = new TreeSet<Integer>();
            for(int i=0;i<n;i++)
                unvisited.add(i);
            int scc=0;
            int v=0;

            while(!unvisited.isEmpty()) {
                v=unvisited.ceiling(v);
                scc++;
                size=0;
                DFS(v, unvisited);
                ll.add(size);
                v++;
            }
            pw.println(scc);
        }
}
