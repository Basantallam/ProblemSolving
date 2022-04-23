/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1=len(headA);
        int len2=len(headB);
        int diff=len1-len2;
        if(diff>0){
            while(diff>0){
                headA=headA.next;
                diff--;
            }
        }
        else if(diff<0){
            while(diff<0){
                headB=headB.next;
                diff++;
            }
        }
        while(headA!=null&&headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }
        return headA;
    }
    public int len(ListNode node){
        int ctr=0;
        while(node!=null) {
            ctr++; node=node.next;
        }
        return ctr;
    }
}
