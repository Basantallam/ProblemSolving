import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HarmoniousGraph {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int arr[][]=new int[e][2];
        int max=0;
        Set<Pair> set = new TreeSet<Pair>();
        Set<Pair> finalset = new TreeSet<Pair>();

        for(int i=0;i<e;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(x>y) {
                int temp = x;
                x=y;
                y=temp;
            }
            arr[i][0]=x-1;
            arr[i][1]=y-1;
            set.add(new Pair(x-1,y-1));
            max=Math.max(max,Math.max(x,y));
        }
        UnionFind uf = new UnionFind(max); //DSU

        for(int i=0;i<e;i++)
            uf.unionSet(arr[i][0],arr[i][1]);
        int ctr=0;

        Iterator<Pair> i = set.iterator();
        Iterator<Pair> j = set.iterator();
        Pair largestpair = j.next();

        while(i.hasNext()) { //PRE-PROCESSING
            i.next();
            while (j.hasNext()) {
                Pair p2 = j.next();
                if(largestpair.y<p2.x) {
                    finalset.add(largestpair);
                    largestpair=p2;
                    break;
                }
                if (p2.y > largestpair.y) {
                    largestpair = new Pair(largestpair.x,p2.y);
                    i.next();
                } else if (p2.x <largestpair.y && p2.y >= largestpair.y) {
                    largestpair=new Pair(largestpair.x,p2.y);
                    i.next();
                }
            }
        }

        finalset.add(largestpair);

        for(Pair p:finalset){
            int x=p.x;
            int y=p.y;
                for(int ii=x;ii<=y;ii++){
                    if(uf.isSameSet(ii,y)) continue;
                    ctr++;
                    uf.unionSet(ii,y);
                }
            }
        System.out.println(ctr);
    }

    static class UnionFind {
        int[] p, rank,setSize;
        int numSets;


        public UnionFind(int N)
        {
            p = new int[numSets = N];
            rank = new int[N];
            setSize = new int[N];
            for (int i = 0; i < N; i++) {  p[i] = i; setSize[i] = 1; }
        }

        public int findSet(int i) { return p[i] == i ? i : (p[i] = findSet(p[i])); }

        public boolean isSameSet(int i, int j) {
            return findSet(i) == findSet(j);
        }

        public void unionSet(int i, int j)
        {
            if (isSameSet(i, j))
                return;
            numSets--;
            int x = findSet(i), y = findSet(j);
            if(rank[x] > rank[y]) { p[y] = x; setSize[x] += setSize[y]; }
            else
            {	p[x] = y; setSize[y] += setSize[x];
                if(rank[x] == rank[y]) rank[y]++;
            }
        }
    }

    public static class Pair implements Comparable<Pair>{
        int x;
        int y;
        public Pair(int x, int y){
            this.x=x;
            this.y=y;
        }
        @Override
        public int compareTo(Pair o) {
            if(x!=o.x) return (x-o.x);
            else return (y-o.y);
        }

    public String toString() {
        return "("+x+","+y+")";
    }
}
}


