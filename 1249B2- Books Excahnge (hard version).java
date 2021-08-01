import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class B2_BooksExchange_hardVersion { //DISJOINT SET UNION
 
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            UnionFind dsu = new UnionFind(n);
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int j = Integer.parseInt(st.nextToken());
                dsu.unionSet(i, j - 1);
            }
 
            for (int i = 0; i < n; i++) {
                System.out.print(dsu.sizeOfSet(i) + " ");
            }
            System.out.println();
        }
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
 
        public boolean isSameSet(int i, int j) { return findSet(i) == findSet(j); }
 
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
 
        public int numDisjointSets() { return numSets; }
 
        public int sizeOfSet(int i) { return setSize[findSet(i)]; }
    }
}