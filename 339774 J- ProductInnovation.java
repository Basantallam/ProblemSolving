import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.temporal.ChronoUnit;
import java.util.StringTokenizer;
 
public class ProductInnovation {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        int nodes=Integer.parseInt(st.nextToken());
        int p=Integer.parseInt((st.nextToken()));
        st = new StringTokenizer(br.readLine());
        Node currNode=null;
        Node start=null;
        Node prev=null;
        for(int i=0;i<nodes;i++){
            Node nw=new Node(prev,Integer.parseInt(st.nextToken()));
            nw.prev=prev;
            if(prev!=null)
                prev.next=nw;
            if(p-1==i){
                currNode=nw;
            }
            if(i==0){
                start=nw;
            }
            prev=nw;
 
        }
 
        int commands=Integer.parseInt(br.readLine());
        for(int i=0;i<commands;i++) {
 
            char[] s=br.readLine().toCharArray();

            if (s[4]=='L'){
                    if(currNode.prev!=null)
                        currNode=currNode.prev;
            }
            else if (s[4]=='R') {
                if (currNode.next != null)
                    currNode = currNode.next;
            }
            else if(s[0]=='p') {
                    System.out.println(currNode.val);
                }
                else if (s[6]=='L') {
                    int x=11;
                        StringBuilder sb = new StringBuilder("");
                        while(x<s.length)
                        {
                            sb.append(s[x]);
                            x++;
                        }
                        Node n1 = new Node(currNode.prev, Integer.parseInt(sb+""));
                        n1.next = currNode;
                        if(currNode.prev!=null)
                            currNode.prev.next=n1;
                        currNode.prev=n1;
 
                    }
                    else if (s[6]=='R') {
                        int x=12;
                        StringBuilder sb = new StringBuilder("");
                        while(x<s.length)
                        {
                            sb.append(s[x]);
                            x++;
                        }
                        Node n1 = new Node(currNode, Integer.parseInt(sb+""));
                        n1.next = currNode.next;
                        if(currNode.next!=null)
                            currNode.next.prev=n1;
                        currNode.next=n1;
 
                    }
 
                }

        }
 
 
    public static class Node{
 
        Node next;
        Node prev;
        int val;
        public Node( Node p,int v){
            prev=p;
            val=v;
        }
        public Node(){
 
        }
     
    }
}
 