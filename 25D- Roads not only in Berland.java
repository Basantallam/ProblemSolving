import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;
 
public class RoadsNotOnlyInBerland {
    static ArrayList<Edge> EdgeList=new ArrayList();
    static ArrayList<Edge> MST=new ArrayList();
    
 public static void main(String[] args) throws IOException {
  Scanner sc=new Scanner(System.in);
  PrintWriter pw=new PrintWriter(System.out);
  int n=sc.nextInt();
  ArrayList<Edge> build=new ArrayList(); 
  ArrayList<Edge> remove=new ArrayList(); 
        DSU dsu=new DSU(n);
     
  while(sc.ready()) {
   
//          System.out.println("waitin" +ctr);
   int i=sc.nextInt();
   int j=sc.nextInt();  
   EdgeList.add(new Edge(i,j)); 
 
  }
  for(Edge curr:EdgeList){
   if(!dsu.isSameSet(curr.i-1,curr.j-1)) {
    dsu.union(curr.i-1,curr.j-1);
    MST.add(curr);
   }
  }
  
  for(int i1=0;i1<n;i1++) {
   for(int z=0;z<n;z++) {
    if(i1==z)
     continue;
    if(!dsu.isSameSet(i1,z)) {
     MST.add(new Edge(i1+1,z+1));
     dsu.union(i1, z);
    }
   }
  }
//  String build="";
  for(Edge e:MST) {
//   System.out.println("MST has "+e);
   if(!EdgeList.contains(e)) {
    build.add(e);
   }
  }
  for(Edge e:EdgeList) {
   if(!MST.contains(e)) {
    remove.add(e);
   }  
 
  }  
  System.out.println(build.size());
 
  while(!build.isEmpty()) {
   pw.println(remove.get(0)+" "+build.get(0));
   build.remove(0);
   remove.remove(0);
  }
  pw.flush();
  
 }
 
 
  static class Edge implements Comparable <Edge>{
   int i;
   int j;
 
   public Edge(int i,int j) {
    this.i=i;
    this.j=j;
   }
 
 
 public int compareTo(Edge o) {
  if(i==o.i && j==o.j || i==o.j && j==o.i)
    return 0;
  else return -1;
 }
 public String toString() {
  return i+" "+j;
 }
 
 
  }
  static class DSU
  {
      int sets;
      int[] rank, parent;
 
      public DSU(int size)
      {
          this.sets = size;
          this.rank = new int[size];
          this.parent = new int[size];
          for(int i = 0; i < size; i++)
          {
              this.parent[i] = i;
          }
      }
 
      public int findSet(int i)
      {
          return i == parent[i] ? i : (parent[i] = this.findSet(parent[i]));
      }
 
      public boolean isSameSet(int i, int j)
      {
          return this.findSet(i) == this.findSet(j);
      }
 
      public void union(int i, int j)
      {
          if(this.isSameSet(i, j))
              return;
          
          sets--;
          int ii = this.findSet(i);
          int jj = this.findSet(j);
          if(rank[ii] > rank[jj])
          {
              parent[jj] = ii;
          }
          else
          {
              parent[ii] = jj;
              if(rank[ii] == rank[jj]) rank[jj]++;
          }
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
