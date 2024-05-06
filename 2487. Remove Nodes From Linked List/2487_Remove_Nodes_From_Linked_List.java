class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        return prev;
    }

    public ListNode removeNodes(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode reversed = reverseList(head);
        ListNode dummy = new ListNode(-1);
        dummy.next = reversed;
        ListNode prev = dummy;
        ListNode curr = reversed;
        int maxSoFar = Integer.MIN_VALUE;

        while (curr != null) {
            if (curr.val < maxSoFar) {
                prev.next = curr.next;
            } else {
                maxSoFar = Math.max(maxSoFar, curr.val);
                prev = curr;
            }
            curr = curr.next;
        }

        return reverseList(dummy.next);
    }
}
