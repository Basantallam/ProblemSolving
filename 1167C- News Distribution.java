import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class NewsDistribution {
 
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int groups = Integer.parseInt(st.nextToken());
 
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < groups; i++){
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            int first=0;
            if(size>0)
                first = Integer.parseInt(st.nextToken());
            for(int j=0;j<size-1;j++){
                uf.unionSet(first-1,Integer.parseInt(st.nextToken())-1);
            }
        }
        for(int i=0;i<n;i++){
           System.out.print(uf.setSize[uf.findSet(i)]+" ");
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
 
    }