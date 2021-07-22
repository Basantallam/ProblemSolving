import java.io.*;
import java.util.*;
public class BeltedRooms {
    static int SCCcout=0; //STRONGLY CONNECTED COMPONENTS
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        PrintWriter pw = new PrintWriter(System.out);
        while(t-->0) {
            int n = Integer.parseInt(br.readLine());
            Graph g = new Graph(n);
            char[] drxn = br.readLine().toCharArray();
            for (int i = 0; i < n; i++) {
                switch (drxn[i]) {
                    case ('<'):
                        g.adj[0][(i+1)%n]=i;
                        break;
                    case ('>'):
                        g.adj[1][i]=(i+1)%n;
                        break;
                    case ('-'): {
                        g.adj[1][i]=(i+1)%n;
                        g.adj[0][(i+1)%n]=i;
                        break;
                    }
                }
            }
            SCCcout=0;
            g.CountSCCs();
            pw.println(SCCcout);
        }
        pw.flush();
 
    }
    static class Graph {
        private int V; // No. of vertices
        private int adj[][]; //Adjacency List
 
        Graph(int v) {
            V = v;
            adj = new int[2][v];
            for(int i=0;i<2;i++)
                Arrays.fill(adj[i],-1);
        }
 
        void DFSUtil(int v, boolean visited[],int depth) {
            visited[v] = true;
            SCCcout++;
 
            int n;
 
            int i = 0;
            boolean nw=true;
            while (i<2) {
                if(adj[i][v]==-1) {
                    i++;
                    continue;
                }
                n = adj[i][v];
                if (!visited[n]){
                    DFSUtil(n, visited,depth+1);
                    nw=false;
                }
            i++;
            }
            if(nw && depth==0){
                SCCcout--;
            }
        }
 
        Graph getTranspose() {
            Graph g = new Graph(V);
            for (int v = 0; v < V; v++) {
                int i=0;
 
                while (i<2 ) {
                    if(adj[i][v]==-1){
                        i++;
                        continue;
                    }
                    if(g.adj[0][adj[i][v]]==-1)
                        g.adj[0][adj[i][v]]=v;
                    else
                        g.adj[1][adj[i][v]]=v;
                    i++;
                }
            }
            return g;
        }
 
        void fillOrder(int v, boolean visited[], Stack stack) {
            visited[v] = true;
 
            int i=0;
            while (i<2) {
                if(adj[i][v]==-1){
                    i++;
                    continue;
                }
                if (!visited[adj[i][v]])
                    fillOrder(adj[i][v], visited, stack);
                i++;
            }
 
            stack.push(new Integer(v));
        }
 
        // connected components
        void CountSCCs() {
            Stack stack = new Stack();
 
            boolean visited[] = new boolean[V];
 
            for (int i = 0; i < V; i++)
                if (visited[i] == false)
                    fillOrder(i, visited, stack);
 
            Graph gr = getTranspose();
 
            for (int i = 0; i < V; i++)
                visited[i] = false;
 
            while (stack.empty() == false) {
                // Pop a vertex from stack
                int v = (int) stack.pop();
 
                if (visited[v] == false) {
                    gr.DFSUtil(v, visited,0);
                }
            }
 
        }
    }
}
 
