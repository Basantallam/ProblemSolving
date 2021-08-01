
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CyclicComponents { //MY SOL

    static Set<Integer> adjList[];
    static Stack<Integer> stack;
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        adjList =new Set[n];
        visited =new boolean[n];
        stack =new Stack<Integer>();

        for (int i=0;i<n;i++)
            adjList[i]=new TreeSet<Integer>();

        for(int i=0;i<e;i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(a!=b){
                adjList[a-1].add(b-1);
                adjList[b-1].add(a-1);
            }
        }

        int count=0;

        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i);
                boolean cnt=true;
                while (!stack.isEmpty()){
                    int x = stack.pop();
                    if(adjList[x].size()!=2) {
                        stack.clear();
                        cnt=false;
                        break;
                    }
                }
                if(cnt) count++;
            }
        }


    System.out.println(count);

    }
   public static void dfs(int u){
        visited[u]=true;
        stack.push(u);
        for(Integer v: adjList[u]){
            if(!visited[v])
                dfs(v);

        }
   }
}
