import java.util.Scanner;
import java.util.*;
 
public class FoxAndNames {
 static HashMap<Character,TreeSet> less;
 static HashMap<Character,TreeSet> more; // topological sort is for DAG NO CYCLES I CAN CHECK FOR THE ABSENCE OF CYCLES
 static String s[];
 static int n;
 static ArrayList<Integer>[] adjList;
 static boolean ans = true;
 
 @SuppressWarnings({ "unchecked", "rawtypes" })
 public static void main(String[] args) {
  
  Scanner sc = new Scanner(System.in);
 
  n = sc.nextInt();
  s = new String[n];
  adjList = new ArrayList[26];
  for (int i = 0; i < 26; i++)
   adjList[i] = new ArrayList();
 
  for (int i = 0; i < n; i++)
   s[i] = sc.next();
 
  less = new HashMap();
  more = new HashMap();
 
  char temp = 'a';
  for (int i = 0; i < 26; i++) {
   less.put(temp, new TreeSet<Character>());
   more.put(temp, new TreeSet<Character>());
   temp++;
  }
  boolean poss = fill();
 
  String topo=topo();
  poss &= ans;
 
  System.out.println(poss ? topo : "Impossible");
 }
 
 public static String topo() {
  Queue<Node> q = new LinkedList();
  int ctr=0;
  for (char c = 'a'; c <= 'z'; c++) {
   if(less.get(c).size()==0) { 
    q.add(new Node(c, less.get(c), more.get(c)));
    ctr++;
   }
   
  }
 
  StringBuilder answer = new StringBuilder("");
  while (!q.isEmpty()) {
   Node curr = q.poll();
 
   answer.append(curr.c);
   for (char x : curr.m) {
    less.get(x).remove((Object) curr.c);
    if(less.get(x).size()==0) {
     q.add(new Node(x, less.get(x), more.get(x)));
     ctr++;
    }
   }
  }
  if(ctr<26)
   ans=false;
  
  return answer + "";
 }
 
 public static boolean fill() {
  boolean equal = true;
  for (int i = 0; i < n - 1; i++) {
   int leni = s[i].length();
   String si = s[i];
   int j = i + 1;
 
   int lenj = s[j].length();
   String sj = s[j];
 
   equal = true;
   that: for (int idx = 0; idx < Math.min(leni, lenj); idx++) {
    if (si.charAt(idx) != sj.charAt(idx)) {
     adjList[si.charAt(idx) - 97].add(sj.charAt(idx) - 97);
     less.get(sj.charAt(idx)).add(si.charAt(idx));
     more.get(si.charAt(idx)).add(sj.charAt(idx));
     equal = false;
     break that;
    }
   }
   if (equal) {
    if (leni > lenj) {
     return false;
    }
   }
 
  }
  return true;
 }
 
 public static class Node {
  char c;
  TreeSet<Character> l;
  TreeSet<Character> m;
 
  @SuppressWarnings("unchecked")
  public Node(char cc, @SuppressWarnings("rawtypes") TreeSet aall, TreeSet mm) {
   c = cc;
   l = aall;
   m = mm;
  }
 }
 
}
