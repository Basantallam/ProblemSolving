import java.util.*;
public class Main{
 public static void main(String[] args)
   { 
  Scanner sc=new Scanner(System.in);
  String all=sc.nextLine();
     String arr[]=all.split(" ");
     int i=0;
    //    System.out.println(Arrays.toString(arr));
    
     String s="";
     int c=0;
     boolean firstletter=true;
        for(int j=0;j<arr.length;j++) {
         c=0;
         while(arr[j]!=" " && c<arr[j].length()) {
          if(letter(arr[j].charAt(c)))
           if(firstletter) 
            
              {s+=" "+arr[j].charAt(c);
                    firstletter=false;}
           
           
              else 
            s+=arr[j].charAt(c);
           
          
          else 
            if(punc(arr[j].charAt(c))) {
            s+=arr[j].charAt(c);
            firstletter=true;}
          c++;
         }
         
           firstletter=true;
       }
      
       System.out.println(s.substring(1,s.length()));
   }
 
 
 public static boolean letter(char c) {
  if(c>='a'&&c<='z') 
   return true;
  return false;
  
 }
 public static boolean punc(char c) {
  if(c=='.'|| c==','|| c=='!'||c=='?') 
   return true;
  return false;
  
 }
 
}
