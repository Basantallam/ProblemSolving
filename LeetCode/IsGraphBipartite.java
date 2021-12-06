class Solution {
    boolean [] visited;
        Integer [] colors;

    public boolean isBipartite(int[][] graph) {
        boolean bool=true;
        visited=new boolean[graph.length];
        colors=new Integer[graph.length];
        for(int i=0;i<graph.length;i++)
            if(!visited[i])
                bool= bool& BFS(graph,i);
        return bool;
    }
    
    
      public boolean BFS(int[][] graph, int i) {

        Queue<Integer> q=new LinkedList<Integer>();
        Queue<Integer> q1=new LinkedList<Integer>();

        q.add(i);
        colors[i]=1;
        int color=0;
        while(!q.isEmpty()){
          
            while(!q.isEmpty()){
                int curNode=q.poll();
                int[] currChildren=graph[curNode];
                for(int c=0;c<currChildren.length;c++) {  
                    if(colors[currChildren[c]]!=null&&color!=colors[currChildren[c]])
                        return false;
                    if(!visited[currChildren[c]])
                        q1.add(currChildren[c]);
                        visited[currChildren[c]]=true;
                        colors[currChildren[c]]=color;
                    }
                }
                q=q1;
                q1=new LinkedList<Integer>();
                color=color ^ 1;
            }
                    
        return true;
    }
}
