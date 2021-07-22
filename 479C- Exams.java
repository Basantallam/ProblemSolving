import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Exams{
 
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Pair exams[]=new Pair[n];
        for(int i=0;i<n;i++){
            String s=br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            exams[i]=new Pair(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(exams);
        int currMin=1;
        for(int i=0;i<n;i++)
            if(exams[i].y>=currMin)
                currMin=exams[i].y;
            else
                currMin=exams[i].x;
        System.out.println(currMin);
    }
    public static class Pair implements Comparable<Pair>{
        int x;
        int y;
        public Pair(int xx, int yy){
            x=xx;
            y=yy;
        }
        @Override
        public int compareTo(Pair o) {
            if(this.x==o.x)
                return this.y-o.y;
            return this.x-o.x;
        }
    }
}
