import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 
public class Fraction {
 
 public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
  int n=sc.nextInt();
        int d=(n/2)+(n%2);
        
        for(int num=n/2;num>0;num--) {
         if(coprime(d,num)) {
           System.out.println(num+" "+d);
           break;
         }
         d++;
        }
 }
 
 
  // method to print the divisors
     static List<Integer> printDivisors(int n)
     {
      List<Integer> listOfDivisors= new ArrayList<>();
      int maxD = (int)Math.sqrt(n);
   for (int i=1; i<=maxD; i++)
   {
          if (n%i==0)
          {
              // If divisors are equal, print only one
              if (n/i == i)
               listOfDivisors.add(i);
              
              // Otherwise print both
              else 
              {
               listOfDivisors.add(i);
               listOfDivisors.add(n/i);
              }
          }
   }
   return listOfDivisors;
     }
     
     public static boolean coprime(int a, int b) {
      List<Integer> l1=printDivisors(a);
      List<Integer> l2=printDivisors(b);
      l1.retainAll(l2);
      if(l1.size()==1 && l1.get(0)==1)
              return true;
      return false;
     }
     
}
