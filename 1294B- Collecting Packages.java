import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class CollectingPackages {
public static void main(String[] args) throws NumberFormatException, IOException {
 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 int t=Integer.parseInt(br.readLine());
 while(t-->0) {
  int n=Integer.parseInt(br.readLine());
  Pair[] packages=new Pair[n+1];
  packages[0]=new Pair(0,0);
  
  for(int i=1;i<=n;i++) {
   String s=br.readLine();
   StringTokenizer st=new StringTokenizer(s);
   int xi=Integer.parseInt(st.nextToken());
   int yi=Integer.parseInt(st.nextToken());
   packages[i]=new Pair(xi,yi);
  }
  
  Arrays.sort(packages);
//  System.out.println(Arrays.toString(packages));
  boolean pos=true;
  StringBuilder ans=new StringBuilder("");
  
  for(int i=0;i<n;i++) {
   
   if(positiveSlope(packages[i].y,packages[i].x,packages[i+1].y,packages[i+1].x)){
    ans.append(move(packages[i].y,packages[i].x,packages[i+1].y,packages[i+1].x));
    continue;
   }
   
   pos=false;
   break;
  }
  System.out.println((pos)?"YES":"NO");
  if(pos)
   System.out.println(ans);
 }
}
 
 public static StringBuilder move(int y, int x, int y2, int x2) {
  StringBuilder sb=new StringBuilder("");
 
  while(x<x2) {
   sb.append("R");
   x++;
  }
 
  while(y<y2) {
   sb.append("U");
   y++;
  }  
 return sb;
}
 
public static boolean positiveSlope(int y1, int x1,int y2,int x2) {
  return (x2>=x1 && y2>=y1);
 
}
 
static class Pair implements Comparable<Pair>{
  int x;
  int y;
  
  public Pair(int xx, int yy) {
   x=xx;
   y=yy;
  }
  
 public int compareTo(Pair o) {
  if (o.y!=y)
   return y-o.y; 
  return x-o.x;
 }
 
 public String toString() {
  return x+" "+y;
 }
 }
}
