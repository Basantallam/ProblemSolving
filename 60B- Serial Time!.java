import java.util.*;
public class Main {
 static char [][][]arr;
 static int[] dx= {0,0,0,0,1,-1};
 static int[] dy= {0,0,1,-1,0,0};
 static int[] dz= {1,-1,0,0,0,0};
 static int l;
 static int n;
 static int minutes=0;
 static int m;
 static boolean explored[][][];
public static void main(String[] args) {//Serial Time
 Scanner sc=new Scanner(System.in);
  l=sc.nextInt();
  n=sc.nextInt();//x
  m=sc.nextInt();//y
 arr=new char[l+1][n+1][m+1];
 explored=new boolean[l+1][n+1][m+1];
 for(int i=1;i<=l;i++) {
  
  for(int j=1;j<=n;j++) {
   
    arr[i][j]=(" "+sc.next()).toCharArray();
     
   
  }
 }
 
 
 
  int tapx=sc.nextInt();
  int tapy=sc.nextInt();
  explore(1,tapx,tapy);
  System.out.println(minutes);
 }
  public static boolean valid(int x,int y,int z) {
   if(x>0 && y>0&&z>0  &&x<=l && y<=n &&z<=m) 
    return true;
   return false;
  }
  public static void explore(int x,int y, int z) {
   
   explored[x][y][z]=true;
   if(arr[x][y][z]=='.') {
    minutes++;
   for(int i=0;i<6;i++) {
    if(valid(x+dx[i],y+dy[i],z+dz[i])&&!explored[x+dx[i]][y+dy[i]][z+dz[i]]) {
     explore(x+dx[i],y+dy[i],z+dz[i]);
    }
   }
   }
   
  }
 
}
