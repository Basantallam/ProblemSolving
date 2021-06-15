import java.util.*;
public class Main{
 public static void main(String[] args)
   { 
  Scanner sc=new Scanner(System.in);
  int n=sc.nextInt();
     int destination=sc.nextInt();
     boolean arr[]=new boolean[destination+1];
     
     for(int i=0;i<n;i++)
     {
      int start=sc.nextInt();
      int end=sc.nextInt();
 
      for(int j=start;j<end;j++) {
       arr[j]=true;
      }
  //    System.out.println(Arrays.toString(arr));
 
     }
    // System.out.println(Arrays.toString(arr));
     for(int i=0;i<destination;i++){
      if(arr[i]==false) {
       System.out.println("NO");
       break;
      }
      if(i==destination-1) {
       System.out.println("YES");
       break;
 
      }
     }
   }
}
