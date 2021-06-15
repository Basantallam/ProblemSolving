import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;
public class Main{ 
 static final int INF = 1000000000;
 static int []dx = {0,0,-1,1,1,1,-1,-1};
 static int []dy=  {1,-1,0,0,1,-1,1,-1};
 static int c;
    static int x;
    static int y;
    static int x1;
    static int y1;
    static TreeSet <cell>allcells =new TreeSet();  // allowed cells
 public static void main(String[] args) throws IOException{
  PrintWriter pw=new PrintWriter(System.out);
  Scanner sc=new Scanner(System.in);
  //initial position
  x=sc.nextInt();
  y=sc.nextInt();
  //final position
     x1=sc.nextInt();
     y1=sc.nextInt();
     //segments
  int s=sc.nextInt();
  c=0;
  for(int i=0;i<s;i++){ // inputting allowed cells
   int row=sc.nextInt();
   int a=sc.nextInt();
   int b=sc.nextInt();  
   for(int j=a;j<=b;j++){
    if(!allcells.contains(new cell(row,j,-1))){ // if doesn't exist
     cell p=new cell(row,j,-1); //make one
        allcells.add(p);
    }
   }
  }
//  System.out.println(allcells);
     
     pw.println(bfs());
     pw.flush();
 
 }
 
public static int bfs() {
 Queue <cell>q=new LinkedList<>();
 q.add(new cell(x,y,0));
 TreeSet<cell> visited=new TreeSet();
 visited.add(new cell(x,y,0));
 while(!q.isEmpty()) {
 
  cell curr=q.poll();
  int j=curr.c;
     int i=curr.r;
     int cost=curr.distance;
     for(int z=0;z<8;z++) {
      
   if(valid(i+dx[z],j+dy[z])&& !visited.contains(new cell(i+dx[z],j+dy[z],cost+1))) {
          q.add(new cell(i+dx[z],j+dy[z],cost+1));
       visited.add(new cell(i+dx[z],j+dy[z],cost+1));
   }
      if(i+dx[z]==x1&& y1==j+dy[z]) {
       return cost+1;
      }
  }
     
 
 }
 return -1;
}
 
public static boolean valid(int a,int b){
 if(a>=0 && b>=0 && a<=INF && b<=INF && allcells.contains(new cell(a,b,-1))) //on grid and allowed cell
   return true; 
 return false;
}
 
 
static class cell implements Comparable<cell>{
      int r;
   int c;
   int distance;
   
   public cell(int row,int col,int dis){
    r=row;
    c=col;
    distance=dis;
   }
   public int compareTo(cell o) {
     if(r!=o.r)
      return r-o.r;
     else return c-o.c;
   }
  public String toString() {
   return r+" "+c+" "+distance;
     
  }
  }
 
static class Scanner 
{
    StringTokenizer st;
    BufferedReader br;
 
    public Scanner(InputStream s){    br = new BufferedReader(new InputStreamReader(s));}
 
    public String next() throws IOException 
    {
        while (st == null || !st.hasMoreTokens()) 
            st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }
 
    public int nextInt() throws IOException {return Integer.parseInt(next());}
    
    public long nextLong() throws IOException {return Long.parseLong(next());}
 
    public String nextLine() throws IOException {return br.readLine();}
    
    public double nextDouble() throws IOException
    {
        String x = next();
        StringBuilder sb = new StringBuilder("0");
        double res = 0, f = 1;
        boolean dec = false, neg = false;
        int start = 0;
        if(x.charAt(0) == '-')
        {
            neg = true;
            start++;
        }
        for(int i = start; i < x.length(); i++)
            if(x.charAt(i) == '.')
            {
                res = Long.parseLong(sb.toString());
                sb = new StringBuilder("0");
                dec = true;
            }
            else
            {
                sb.append(x.charAt(i));
                if(dec)
                    f *= 10;
            }
        res += Long.parseLong(sb.toString()) / f;
        return res * (neg?-1:1);
    }
    public boolean ready() throws IOException {return br.ready();}
 
 
}
}
