import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class MysteriousPhotos{
 
    public static void main (String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Pair a[]=new Pair[3];
        Pair b[]=new Pair[3];
 
        for(int i=0;i<3;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            a[i]=new Pair(0,0);
            a[i].x=Integer.parseInt(st.nextToken());
            a[i].y=Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<3;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            b[i]=new Pair(0,0);
            b[i].x=Integer.parseInt(st.nextToken());
            b[i].y=Integer.parseInt(st.nextToken());
        }

        double a1=dist(a[0],a[1]);
        double a2=dist(a[1],a[2]);
        double a3=dist(a[2],a[0]);
 
        double b1=dist(b[0],b[1]);
        double b2=dist(b[1],b[2]);
        double b3=dist(b[2],b[0]);
 
        double r1=a1/b1;
        double r2 =a1/b2;
        double r3= a1/b3;
        double r4= a2/b1;
        double r5= a2/b2;
        double r6= a2/b3;
        double r7= a3/b1;
        double r8= a3/b2;
        double r9= a3/b3;

        if(r1==r5 && r5==r9)
            System.out.println("YES");
        else if(r1==r6 && r6==r8)
            System.out.println("YES");
        else if(r2==r6 && r6==r7)
            System.out.println("YES");
        else if(r2==r4 && r4==r9)
            System.out.println("YES");
        else if(r3==r4&&r4==r8)
            System.out.println("YES");
        else if(r3==r5 &&r5==r7)
            System.out.println("YES");
        else System.out.println("NO");
 
    }
    static class Pair{
        int x;
        int y;
        public Pair(int xx, int yy){
            x=xx;
            y=yy;
        }
        public String toString(){
            return"("+x+", "+y+")";
        }
    }
    public static double dist(Pair p1, Pair p2){
        return ((p1.x-p2.x)*(p1.x-p2.x))+((p1.y-p2.y)*(p1.y-p2.y));
    }
 
 
}