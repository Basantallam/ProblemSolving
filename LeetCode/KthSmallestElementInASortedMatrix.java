class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Pair> pq=new PriorityQueue<Pair>();
        int[] ptr=new int[matrix.length];
        
        for(int i=0;i<matrix.length;i++)
            pq.add(new Pair(matrix[i][0],i));
        int ctr=0;
        while(ctr<k-1){
            
            Pair top=pq.poll();
            ptr[top.subarray]++;
            if(matrix[top.subarray].length>ptr[top.subarray]){
                pq.add(new Pair(matrix[top.subarray][ptr[top.subarray]],top.subarray));
            }
            ctr++;
        }
        return pq.poll().val;
    }
    
    public class Pair implements Comparable<Pair>{
        int val;
        int subarray;
        public Pair(int v,int s){
            val=v;
            subarray=s;
        }
        public int compareTo(Pair p){
            return val-p.val;
        }
    }
}
