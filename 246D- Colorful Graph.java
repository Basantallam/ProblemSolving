import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
 
public class Main {
 
 static Node[] nodes;
 @SuppressWarnings("unchecked")
 public static void main(String[] args) throws NumberFormatException, IOException {
  Scanner sc=new Scanner(System.in);
  int n=sc.nextInt();
  int m=sc.nextInt();
  Node[] nodes=new Node[n+1];
  ArrayList<Node>[] adjList=new ArrayList[n+1];
  ArrayList<Integer>[] allcolors=new ArrayList[1000000];//********
  TreeSet Q=new TreeSet();
  TreeSet colorset=new TreeSet();
  
   for(int i = 0; i < adjList.length; i++)
         adjList[i]=new ArrayList<Node>();
   
  for(int i=1;i<=n;i++) {
    int colno=sc.nextInt();
    nodes[i]=new Node(i,colno);
    
    if((allcolors[colno]==null)) {
      allcolors[colno]=new ArrayList();
      allcolors[colno].add(i);    //adding node no
      colorset.add(colno);    //adding new color
   }else {
     allcolors[colno].add(i); //adding node no
   }
    
   
  }
  
  for(int i=0;i<m;i++) {
   int n1=sc.nextInt();
   int n2=sc.nextInt();
   int x=nodes[n1].uniqueno;
   adjList[x].add(nodes[n2]);
   adjList[nodes[n2].uniqueno].add(nodes[n1]);
  }
  int mincol=0;
  //System.out.println("adj list"+Arrays.deepToString(adjList));
//   System.out.println();
  int maxsize=0;
  int maxcol=0;
//  System.out.println(colorset+"col set");
//  System.out.println(Arrays.deepToString(allcolors)+"all cols ");
  int s=colorset.size();
   for(int i = 0; i <s; i++) {
   
    int currcol=(int) colorset.pollFirst();
//    System.out.println(currcol);
    if(i==0)
     mincol=currcol;
    for(int j: allcolors[currcol]) {
     for(int k=0;k<adjList[j].size();k++) //el color el mohaddad
      if(adjList[j].get(k).color !=currcol)
          Q.add(adjList[j].get(k).color); // nodes el color da
    }
     
   
//    System.out.println("color: "+currcol+" neighbours "+ Q);
    if(Q.size()>maxsize) {
     maxsize=Q.size();
     
     maxcol=currcol;
    }
   Q.clear();  
   }
   if(maxcol==0)
     maxcol=mincol;
     System.out.println(maxcol);
  
   }
   static class Node{
   int uniqueno=0; int color=0;
   public Node(int u, int c) { uniqueno=u; color=c; }
   public String toString() { return uniqueno+" "+color;}
  }
 
}
