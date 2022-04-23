class Solution {
    static int color;
    static int[] dx={1,-1,0,0};
    static int[] dy={0,0,1,-1};
    static HashMap<Integer,Integer> map;
    public int largestIsland(int[][] grid) {
        color=2;
        map=new HashMap<Integer,Integer>();
        int maxCount=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    int count=dfs(i,j,grid);
                    maxCount=Math.max(maxCount,count+1);
                    map.put(color,count);
                    color++;
                }
            }
        }

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                ArrayList<Integer>list=new ArrayList<Integer>();
                Set<Integer> set=new HashSet<Integer>();
                for(int d=0;d<4;d++){
                    if(i+dx[d]>=0 && i+dx[d]<grid.length && j+dy[d]<grid[0].length && 
                        j+dy[d]>=0 && grid[i+dx[d]][j+dy[d]]!=0){
                        if(!set.contains(grid[i+dx[d]][j+dy[d]])){
                            set.add(grid[i+dx[d]][j+dy[d]]);
                            list.add(map.get(grid[i+dx[d]][j+dy[d]]));
                        }
                    }
                }
                int sum=1;
                for(int x:list) sum+=x;
                maxCount=Math.max(sum,maxCount);
            }
        }
        if(maxCount>grid.length*grid[0].length) maxCount--;

        return Math.max(1,maxCount);
    }
    
    public int dfs(int i, int j,int[][] grid){

        grid[i][j]=color;
        int sum=1;
        for(int d=0;d<4;d++)
            if(i+dx[d]>=0 && i+dx[d]<grid.length && j+dy[d]<grid[0].length && 
               j+dy[d]>=0 && grid[i+dx[d]][j+dy[d]]==1)
                sum+= dfs(i+dx[d],j+dy[d],grid);
        return sum;   
    }
}
