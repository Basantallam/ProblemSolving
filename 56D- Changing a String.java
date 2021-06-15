import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;
 
public class ChangingaString2 {
 static int[][] memo;
 static String s1;
 static String s2;
 final static int INF = (int) 1e9;
 
 static Stack <Pair> stack=new Stack<Pair>();
 public static void main(String[] args) throws IOException {
  Scanner sc = new Scanner(System.in);
  s2 = sc.next();
  s1 = sc.next();
 
  memo = new int[s1.length() + 2][s2.length() + 2];
  for (int i = 0; i < s1.length() + 1; i++)
   Arrays.fill(memo[i], INF);
 
  memo[0][0] = 0;
  s1 = " " + s1;
  s2 = " " + s2;
 
  for (int i = 1; i < s1.length(); i++)
   memo[i][0] = 1 + memo[i - 1][0];
 
  for (int i = 1; i < s2.length(); i++)
   memo[0][i] = 1 + memo[0][i - 1];
 
  System.out.println(dp(s1.length() - 1, s2.length() - 1));
  dptrace(s1.length() - 1, s2.length() - 1);
  pop();
 }
 public static void pop() {
  int ctr=1;
  while(!stack.isEmpty()) {
   Pair curr=stack.pop();
   switch(curr.operation) {
   case 'r': System.out.println("REPLACE "+ ctr+ " "+curr.chr ); ctr++;
   break;
   case 'i': System.out.println("INSERT "+ ctr +" "+curr.chr ); ctr++;
   break;
   case 'd': System.out.println("DELETE "+" "+ ctr );
   break;
   case 'l': ctr++;
   break;
   }
    
  }
 }
 
 public static int dp(int i1, int i2) {
 
  if (i1 == 0 || i2 == 0)
 
   return memo[i1][i2];
 
  if (memo[i1][i2] != INF)
   return memo[i1][i2];
 
  if (s1.charAt(i1) == s2.charAt(i2)) {
   return memo[i1][i2] = dp(i1 - 1, i2 - 1);
  }
 
  else {
   return memo[i1][i2] = 1 + Math.min(dp(i1 - 1, i2 - 1), Math.min(dp(i1 - 1, i2), dp(i1, i2 - 1)));
  }
 }
 
 public static void dptrace(int i1, int i2) {
 
  if (i1 == 0 && i2 == 0)
   return;
  
  if (i1 == 0 ) {
   for(int i=1;i<=i2;i++) {
   stack.push(new Pair('d'));
   }
   return;
  }
  
  if(i2 == 0) {
   for(int i=i1;i>0;i--) {
    stack.push(new Pair('i', s1.charAt(i)));
   }
   return;
  }
 
  if (memo[i1][i2] == memo[i1][i2 - 1] + 1) {
   stack.push(new Pair('d'));
   dptrace(i1, i2 - 1 );
 
  } else if (memo[i1][i2] == memo[i1 - 1][i2] + 1) {
   stack.push(new Pair('i', s1.charAt(i1)));
   dptrace(i1 - 1, i2);
 
  } else if (memo[i1][i2] == memo[i1 - 1][i2 - 1]) {
   stack.push(new Pair('l'));
   dptrace(i1 - 1, i2 - 1);
//   System.out.println(s1.charAt(i1)+" like");
  } else {
   if (memo[i1][i2] == memo[i1 - 1][i2 - 1] + 1) {
    stack.push(new Pair('r', s1.charAt(i1)));
    dptrace(i1 - 1, i2 - 1);
   }
  }
 }
 
//   B A D
// G
//  O
// O
// D
 
//  0 ACCEPTED
//   W 1
//   R  2 
//   O   3 
//   N    4
//   G      5
//   A       6
//   N       7
//   S       8
//   W       9
//   E       9
//   R        10
 
 static class Pair {
  char operation;
  char chr;
  public Pair(char o,char c) {
   operation=o;
   chr=c;
   
  }
  public Pair(char o) {
   operation=o;
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
 
   
 }
}
