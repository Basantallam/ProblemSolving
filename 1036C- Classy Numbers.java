import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class ClassyNumbers { 
 static long memo[][][][]; 
 static int[] L; 
 static int[] R;  
 public static void main(String[] args) throws IOException {
  Scanner sc=new Scanner(System.in);
  int T=sc.nextInt();
  while(T-->0) {
   
   String l=sc.next();
   String r=sc.next();
   
   memo=new long[2][2][4][r.length()+1];
   
   for(int i=0;i<2;i++)
    for(int i1=0;i1<2;i1++)
     for(int i11=0;i11<4;i11++)
      Arrays.fill(memo[i][i1][i11],-1);
   
   
   L=new int[r.length()];
   R=new int[r.length()];
   
   int diff=r.length()-l.length();
   for(int i=0;i<diff;i++) 
    l="0"+l;
   
   for(int i=0;i<r.length();i++)
   {
    L[i]=Integer.parseInt(l.charAt(i)+"");
    R[i]=Integer.parseInt(r.charAt(i)+"");
   }
   
   System.out.println(dp(true,true,0,0));
  }
 }
 
 public static long dp(boolean Upper,boolean Lower, int nonzero,int idx) {
  
  if(idx==R.length && nonzero<=3)
   return 1;
   
  if(nonzero>3||idx==R.length)
   return 0;
  
  if(memo[Upper?1:0][Lower?1:0][nonzero][idx]!=-1)
   return memo[Upper?1:0][Lower?1:0][nonzero][idx];
  
  int sum=0;
  int start=0;
  int end=9;
  
  if(Upper)  end=R[idx];
  
  if(Lower)  start=L[idx];
 
  for(int i=start; i<=end;i++) 
   sum+=dp(Upper&(i==R[idx]),Lower& (i==L[idx]), i==0?nonzero:nonzero+1, idx+1); 
  
  return memo[Upper?1:0][Lower?1:0][nonzero][idx]= sum;
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
     
 
 }
}
