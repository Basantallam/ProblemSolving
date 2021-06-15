 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
 
public class CandyBags {
static ArrayList<Integer> []arr;
 public static void main(String[] args) {
  Scanner sc=new Scanner(System.in);
  int n=sc.nextInt();
  arr=new ArrayList[n];
  
  for(int i=0;i<n;i++)
   arr[i]=new ArrayList();
  
  int ptr=1;
  int diff=2*n-1;
  
  for(int i=0;i<n/2;i++) {
   for(int i1=0;i1<n;i1++)
   {
    arr[i1].add(ptr);
    arr[i1].add(ptr+diff);
    diff-=2;
    ptr++;
   }
   ptr+=n;
   diff=2*n-1;
  }
  for(int i=0;i<n;i++) {
   for(int u:arr[i])
    System.out.print(u+" ");
   System.out.println();
  }
//  System.out.println(Arrays.toString(arr));
 }
 
}
