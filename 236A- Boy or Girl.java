import java.util.*;
 
import java.util.TreeSet;
public class BoyOrGirl {
 
    public static void main(String[] args)  {
    
     TreeSet<String> set = new TreeSet<>();    
     Scanner s= new Scanner(System.in);
     String name=s.next();
     for(int i=0;i<name.length();i++) {
      set.add(name.charAt(i)+"");
     }
     if(set.size()%2==0) {
      System.out.println("CHAT WITH HER!");
     }
     else {
      System.out.println("IGNORE HIM!");
     }
    }
  
}
