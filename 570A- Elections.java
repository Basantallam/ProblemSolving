import java.util.Arrays;
import java.util.Scanner;
 
public class Elections {
 
 public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);
      int n=sc.nextInt();  //ppl
      int m=sc.nextInt(); //cities
      Pair[] votes=new Pair[n];
      int[] ctr=new int[n];
      
  for(int i=0;i<m;i++) {
   for(int j=0;j<n;j++) {
    votes[j]=new Pair(j, sc.nextInt());
   }
   Arrays.sort(votes);
//   System.out.println(Arrays.toString(votes));
   ctr[votes[0].idx]++;
  }
  int max=ctr[0];
  int idxmax=0;
  
      for(int i=0;i<n;i++){
       if(max<ctr[i]) {
        max=ctr[i];
        idxmax=i;
       }
      }
      
      System.out.println(idxmax+1);
 }
 static class Pair implements Comparable<Pair>{
  int idx;
  int n;
  
  public Pair(int idx, int n) {
   this.idx=idx;
   this.n=n;
  }
  public int compareTo(Pair o) {
   if(o.n-n!=0)
    return o.n-n;
   else
    return idx-o.idx;
  }
  public String toString() {
   return idx+" "+n;
  }
 }
}
