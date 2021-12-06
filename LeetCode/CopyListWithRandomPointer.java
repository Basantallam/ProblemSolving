class Solution {
    Node [] arr;
    public Node copyRandomList(Node head) {
        if(head==null)
            return null;
        Node Head=head;
        int len=0;
        while(Head!=null){
            len++;
            Head=Head.next;
        }
        Head=head;
        arr=new Node[len];
        fillarr(Head);
        Node firstNode=baseCopy(head);
        randomCopy(head);
        next(head,1);

        return firstNode;
    }
    public Node baseCopy(Node node){
        if(node==null)
            return null;
        Node newNode=new Node(node.val);
        Node next = node.next;
        node.next=newNode;
        newNode.next=node;
        newNode.random=(baseCopy(next));
        return newNode;
    }
    public void randomCopy(Node node){
        
        Node newNode=node.next;
        Node newnewNode=newNode.random;

        if(node.random!=null)
            newNode.random=node.random.next;
        else
            newNode.random=null;
        newNode.next=newnewNode;

        if(newnewNode!=null)
             randomCopy(newnewNode.next);
         
    }
    public void fillarr(Node head){
        int i=0;
        while(head!=null){
            arr[i]=head;
            head=head.next;
            i++;
        }
    }
    public void next(Node node, int idx){
        if(idx==arr.length){
            node.next=null;
            return;
        }
        node.next=arr[idx];
        next(node.next,idx+1);
    }
}
