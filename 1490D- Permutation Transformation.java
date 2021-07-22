import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class PermutationTransformation {
    static int[] arr;
    static int[] res;
 
    public static void main (String [] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int t= Integer.parseInt(br.readLine());
        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr=new int[n];
            res=new int[n];
 
            for(int i=0;i<n;i++)
                arr[i]= Integer.parseInt(st.nextToken());
 
            findMax(0,n,0);
            for(int i=0;i<n;i++)
                System.out.print(res[i]+" ");
            System.out.println();
        }
 
    }
 
    public static void findMax(int start, int end, int depth) {
        if(start==arr.length)
            return;
        if(start==end-1)
        {
            res[start]=depth;
            return;
        }
        if(start==end||start>end)
            return;
        int max = 0;
        int maxIdx = 0;
        for (int i = start; i < end; i++) {
            if (max < arr[i]) {
                maxIdx = i;
                max = arr[i];
            }
        }
        res[maxIdx]=depth;
        findMax(start,maxIdx,depth+1);
        findMax(maxIdx+1,end,depth+1);
    }
 
 
}
