class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return calc(l1,l2,false);
    }
    public ListNode calc(ListNode l1, ListNode l2,boolean carry){
        if(l1==null&&l2==null)
            return null;
        
         if(l1==null)
            return l2;
        
        if(l2==null)
            return l1;
        
        int sum=(carry?1:0)+l1.val+l2.val;
        boolean c=false;
        if(sum>=10){
            sum-=10;
            c=true;
        }
        ListNode node=new ListNode(sum);
        if(c){
            if(l1.next==null){
                l1.next=new ListNode(1);
                c=false;
            }else{
                if(l2.next==null){
                    l2.next=new ListNode(1);    
                    c=false;

                }   
            }               
        }
        node.next=calc(l1.next,l2.next,c);
        return node;
    }
}
