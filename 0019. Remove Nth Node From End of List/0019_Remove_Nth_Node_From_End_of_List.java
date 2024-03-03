class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        int count = 0;

        while(curr!=null) {
            count++;
            curr = curr.next;
        }
        int steps = count-n;
        if(steps==0) return head.next;
        curr = head;
        for(int i=1; i<steps; i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;

        return head;
    }
}
