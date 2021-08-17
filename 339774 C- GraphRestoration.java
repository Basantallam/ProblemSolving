import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class GraphRestoration{
    static int INF =(int) 1e9;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        V=n;
        adjMatrix= new int [n][n];
        ans=new int[n][n];
 
        boolean good=true;
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
           for(int j=0;j<n;j++){
               ans[i][j]=adjMatrix[i][j]=Integer.parseInt(st.nextToken());
               if(i==j &&adjMatrix[i][j]!=0)
                   good=false;
               if(adjMatrix[i][j]==0){
                   adjMatrix[i][j]=INF;
               }
           }
        }
        floyd();
        if(!good) {
            System.out.println(-1);
         }else{
            boolean done=false;
            outer:for(int i=0;i<n;i++) {
                for (int j = 0; j < n; j++)
                    if (i!=j&&ans[i][j] != adjMatrix[i][j]) {
                        System.out.println(-1);
                        done=true;
                        break outer;
                    }
            }
            if(!done){
                for(int i=0;i<n;i++) {
                    for (int j = 0; j < n; j++)
                        System.out.print(ans[i][j] + " ");
                    System.out.println();
                }
            }
 
        }
 
    }
 
 
    static int[][] adjMatrix;
    static int[][] ans;
 
    static int[][] p;
    static int V;
 
    static void floyd()
    {
        //adjMatrix contains: directed edges, zero for i=j, INF (1B) otherwise
 
        p = new int[V][V];		//to find the parent on the shortest path
        for(int i = 0; i < V; i++)
            for(int j = 0; j < V; j++)
                p[i][j] = i;
 
        for(int k = 0; k < V; k++)
            for(int i = 0; i < V; i++)
                for(int j = 0; j < V; j++)
                    if(adjMatrix[i][j] > adjMatrix[i][k] + adjMatrix[k][j])
                    {
                        adjMatrix[i][j] = adjMatrix[i][k] + adjMatrix[k][j];
                        p[i][j] = p[k][j];
                    }
    }
}