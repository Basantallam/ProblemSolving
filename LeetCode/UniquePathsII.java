class Solution {
    int[][]grid;
    long [][] s;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        grid=obstacleGrid;
        s=new long[obstacleGrid.length][obstacleGrid[0].length];
        for(int i=0;i<obstacleGrid.length;i++)
            Arrays.fill(s[i],-1);
        int x=(int)sum(grid.length-1,grid[0].length-1);
      
            return x;
    }
    
    public long sum(int row, int col){
        if(row<0||col<0||grid[row][col]==1)
            return 0;
        
        if(row==0&&col==0){
            s[row][col]=1;
            return 1;
        }
                
        if(s[row][col]!=-1)
            return s[row][col];
        return s[row][col]=sum(row-1,col)+sum(row,col-1);
    }
}
