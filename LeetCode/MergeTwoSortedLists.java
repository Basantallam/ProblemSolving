/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;
        ListNode prev=null;
        ListNode next=list1;
        ListNode curr = list2;
        
        while( next!=null && curr!=null){   
            if(next.val>=curr.val){
                if(prev==null)
                { 
                    prev=new ListNode(curr.val,next);
                    list1=prev;
                }
                else { prev.next = curr; prev=curr;}
                ListNode newcurr = curr.next;
                curr.next=next;
                curr=newcurr;
            }
            else{
                prev=next;
                next=prev.next;
            }
        }
        while(next==null&&curr!=null){
            prev.next=curr;
            curr=curr.next;
            prev=prev.next;
        }        
        return list1;
    }
}
