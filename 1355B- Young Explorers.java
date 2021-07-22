import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class youngExplorers {
 
        public static void main(String[] args) throws IOException {
            BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            while(t-->0){
 
            int n = Integer.parseInt(br.readLine());
            int ppl[]=new int[n];
                String s=br.readLine();
                StringTokenizer st = new StringTokenizer(s);
 
            for(int i=0;i<n;i++)
                ppl[i]=Integer.parseInt(st.nextToken());
 
            Arrays.sort(ppl);
            int currCount=0;
            int grps=0;
 
            for(int i=0;i<n;i++)
            {
                if(++currCount==ppl[i]){
                    grps++;
                    currCount=0;
                }
            }
                System.out.println(grps);
 
    }
}
}
