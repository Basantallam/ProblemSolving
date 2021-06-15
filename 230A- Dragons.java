import java.util.*;
public class Main{
 
 public static void main(String[] args)
   {
    Scanner sc= new Scanner(System.in);
    boolean won =true;
    int  strength=sc.nextInt();
    int  n=sc.nextInt();
    Dragon[] arr=new Dragon[n];
    for(int j=0;j<n;j++) {
     int x=sc.nextInt();
     int y=sc.nextInt();
     Dragon dr=new Dragon();
     dr.NewDragon(x,y);
     arr[j]=dr;
    }
    sc.close();
   Arrays.sort(arr);
  
   int index=0;
   int maxbonus=0;
 
   for(int j=0;j<n;j++) {       //loop until all dragons are fought.. j=no. of dragons fought
     
     int i=0;
     maxbonus=0;
     while(i<n-j && arr[i].s>=strength) { //choosing dragon of largest bonus within player strength
   
       i++;
        }
     if(i==n-j) { //if didn't find low enough strength 
   won=false; 
   break;
     } 
     index=i;
     maxbonus=arr[i].b;
     i=0;
   strength+=maxbonus;
//         for (int k=0;k<n-j;k++) { //test test
//   System.out.println(arr[k].s+" "+arr[k].b);
//      }
      for (int k=index;k<n-1-j;k++) { //removing the dragon u fought
     arr[k]=arr[k+1];
     }
    
    }
    System.out.println(won?"YES":"NO");
    }
 
  public static class Dragon implements Comparable<Dragon> { 
   int s;       //strength
   int b;       //bonus
   
  public void NewDragon(int x,int y) {
  this.s=x;
        this.b=y;
   }
 
  public int compareTo(Dragon d) {      // sorts based on bonus in descending order
   return   d.b-this.b;
  }
 
   }
}
