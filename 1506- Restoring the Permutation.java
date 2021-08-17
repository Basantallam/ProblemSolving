import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;
 
public class RestoringThePermutation{
    static TreeSet<Integer> set;
    public static void main (String[] args) throws IOException {
        PrintWriter pw =new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t= Integer.parseInt(br.readLine());
 
 
        while(t-->0){
            set= new TreeSet<>();
            int currMax=0;
            int n= Integer.parseInt(br.readLine());
            int[] arr =new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++)
                arr[i]=Integer.parseInt(st.nextToken());
            for(int i=0;i<n;i++){
//                System.out.println(set);
                if(currMax<arr[i]){
                    addTill(currMax,arr[i]);
                    currMax = arr[i];
                    pw.print(arr[i]+" ");
                }
                else{
                    int x=set.first();
                    set.remove(x);
                    pw.print(x+" ");
                }
            }
            pw.println();
            currMax=0;
            for(int i=0;i<n;i++){
//                System.out.println(set);
                if(currMax<arr[i]){
                    addTill(currMax,arr[i]);
                    currMax = arr[i];
                    pw.print(arr[i]+" ");
                }
                else{
                    int x=set.last();
                    set.remove(x);
                    pw.print(x+" ");
                }
            }
 
        pw.println();
        pw.flush();
    }
 
    }
    public static void addTill(int from, int to){
        //] .. [
//        System.out.println(from+"-"+to);
        for(int i=from+1;i<to;i++)
            set.add(i);
 
    }
 
}