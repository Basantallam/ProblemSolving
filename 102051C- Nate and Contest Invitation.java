import java.util.*; 
 
public class NateAndContestInvitation {
 
	public static void main(String[] args) {
		HashMap<String ,Integer> hm=new HashMap();
        Scanner sc=new Scanner(System.in);
        int nodes=sc.nextInt();
        int edges=sc.nextInt();
        int invitations=sc.nextInt();
        int ctr=0;
        DSU dsu=new DSU(nodes);
        
        while(edges-->0) {
        	String s=sc.next();
        	int n1=0;
        	int n2=0;
        	if(hm.containsKey(s)) {
        		n1=hm.get(s);
        	}else {
        		hm.put(s, ctr);
        		n1=ctr;
        		ctr++;
        	}
        	
        	s=sc.next();
        	if(hm.containsKey(s)) {
        		n2=hm.get(s);
        	}else {
        		hm.put(s, ctr);
        		n2=ctr;
        		ctr++;
        	}
        	
        	dsu.union(n1, n2);
        }
        int[] arr=new int[nodes];
        int idx=0;
        for(int i=0;i<nodes;i++) {
        	if(dsu.parent[i]==i) {
        		arr[idx++]=dsu.getSetSize(i);
        	}
        }
        shuffle(arr);
        Arrays.sort(arr);
        int i= arr.length-1;
        int sum=0;
        
        while(invitations-->0) {
        	
        	sum+=arr[i];
        	i--;
        }
        System.out.println(sum);
	}
 
		static void shuffle(int[] a)
		{
			int n = a.length;
			for(int i = 0; i < n; i++)
			{
				int r = i + (int)(Math.random() * (n - i));
				int tmp = a[i];
				a[i] = a[r];
				a[r] = tmp;
			}
		
 
	}
 
static class DSU 
 
	{ 
 
	    int sets; 
 
	    int[] rank, parent, setSize; 
 
	  
 
	    public DSU(int size) 
 
	    { 
 
	        this.sets = size; 
 
	        this.rank = new int[size]; 
 
	        this.parent = new int[size]; 
 
	        this.setSize = new int[size]; 
 
	        for(int i = 0; i < size; i++) 
 
	        { 
 
	            this.parent[i] = i; 
 
	            this.setSize[i] = 1; 
 
	        } 
 
	    } 
 
	  
 
	    public int findSet(int i) 
 
	    { 
 
	        return i == parent[i] ? i : (parent[i] = this.findSet(parent[i])); 
 
	    } 
 
	  
 
	 
 
	 
 
	    public boolean isSameSet(int i, int j) 
 
	    { 
 
	        return this.findSet(i) == this.findSet(j); 
 
	    } 
 
	  
 
	    public void union(int i, int j) 
 
	    { 
 
	        if(this.isSameSet(i, j)) 
 
	            return; 
 
	         
 
	        sets--; 
 
	        int ii = this.findSet(i); 
 
	        int jj = this.findSet(j); 
 
	        if(rank[ii] > rank[jj]) 
 
	        { 
 
	            parent[jj] = ii; 
 
	            setSize[ii] += setSize[jj]; 
 
	        } 
 
	        else 
 
	        { 
 
	            parent[ii] = jj; 
 
	            setSize[jj] += setSize[ii]; 
 
	            if(rank[ii] == rank[jj]) rank[jj]++; 
 
	        } 
 
	    } 
 
	    public int getSets() 
 
	    { 
 
	        return this.sets; 
 
	    } 
 
	     public int getSetSize(int i) 
 
	    { 
 
	        return this.setSize[this.findSet(i)]; 
 
	    } 
 
	} 
 
}