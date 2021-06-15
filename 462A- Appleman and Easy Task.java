 
import java.util.Scanner;
 
public class AppleManAndEasyTask {
    static int[] dx= {1,-1,0,0};
    static int[] dy= {0,0,-1,1};
    static int n;
    static char [][] arr;
 public static void main(String[] args) {
  
  Scanner sc=new Scanner(System.in);
     n=sc.nextInt();
  arr=new char[n][n];
  
  for(int i=0;i<n;i++) {
   arr[i]=sc.next().toCharArray();
  }
 System.out.println((YN())?"YES":"NO");
 }
 
 public static boolean valid(int x, int y)
 {
  if(x>=0 && y>=0 && x<n && y<n)
   return true;
  
  return false;
     
 }
    public static boolean YN(){
     
     for(int i=0;i<n;i++) {
   for(int j=0;j<n;j++) {
    int ctr=0;
    for(int d=0;d<4;d++) {
     int nxtX=dx[d]+i;
     int nxtY=dy[d]+j;
      if(valid(nxtX,nxtY) && arr[nxtX][nxtY]=='o')
       ctr++;
       
    }
    if(ctr%2!=0)
     return false;
   }
   
  }
  return true;
    }
}
 
