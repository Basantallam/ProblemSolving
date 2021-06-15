import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;
 
public class Maze {
  static int[] dx= {0,0,1,-1};
  static int[] dy= {1,-1,0,0};
  static int n;
  static int k;
  static int ctr=0;
  static int m;
  static boolean[][] visited;
  static char[][] maze;
  static Point grid[][];
  static int good=0;
  static PriorityQueue <Point>pq=new PriorityQueue();
 public static void main(String[] args) {
     Scanner sc=new Scanner(System.in);
        m=sc.nextInt(); //rows
        n=sc.nextInt();
        k=sc.nextInt();
        maze=new char[m][n];
        visited=new boolean[m][n];
        grid=new Point[m][n];
        
        for(int i=0;i<m;i++) {
          maze[i]=sc.next().toCharArray();
        }
        for(int i=0;i<m;i++)
         for(int j=0;j<n;j++)
          grid[i][j]=new Point(i,j);
        
        for(int i=0;i<m;i++)
         for(int j=0;j<n;j++)
              if(maze[i][j]=='#') {
               
               grid[i][j].child=11;
               grid[i][j].parent=null;
              }
        
       outer:  for(int i1=0;i1<m;i1++) {
         for(int j1=0;j1<n;j1++)  {     
          if(maze[i1][j1]=='.') {
             dfs(i1,j1);
                   break outer;
          }
         }
      }
         
         for(int i1=0;i1<m;i1++) {
            for(int j1=0;j1<n;j1++)  { 
             if(grid[i1][j1].child==0) {
              pq.add(grid[i1][j1]);
             }
            }
         }
        helper();
       
        for(int i1=0;i1<m;i1++) {
         for(int j1=0;j1<n;j1++) {
          System.out.print(maze[i1][j1]);
         }
         System.out.println();
        }
  
 }
    public static void dfs(int i,int j){
     visited[i][j]=true;
     
     
     for(int i1=0;i1<4;i1++) {
      if(valid(i+dx[i1],j+dy[i1])){
         grid[i+dx[i1]][j+dy[i1]].parent=grid[i][j];
         grid[i][j].child++;
            dfs(i+dx[i1],j+dy[i1]);
      }
     }
    
    }
    
 private static boolean valid(int i, int j) {
        if(i>=0 && i<m && j>=0 && j<n && maze[i][j]=='.' && !visited[i][j])
         return true;
  return false;
 }
 
 public static void helper() {
 
  while(ctr<k) {
//   for(int i1=0;i1<m;i1++) {
//    for(int j1=0;j1<n;j1++) {
//     System.out.print(grid[i1][j1].child+" ");
//    }
//    System.out.println();
//   }
//   System.out.println();
 
    Point curr=pq.poll();
    maze[curr.i][curr.j]='X'; 
    grid[curr.i][curr.j].child=-1; 
    grid[curr.i][curr.j].parent.child--;
    if(grid[curr.i][curr.j].parent.child==0)
     pq.add(grid[curr.i][curr.j].parent);
    
          ctr++;
  }
  
 }
 
static class Point implements Comparable<Point>{
 int i;
 int j;
 int child;
 Point parent;
 public Point(int a,int b) {
  i=a;
  j=b;
 }
 @Override
 public int compareTo(Point o) {
  return child-o.child;
 }
 public String toString () {
  return "("+child+")";
 }
 
 
}
}
