class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode prev = null, curr = slow, tmp;
        while (curr != null) {
            tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }

        ListNode n1 = head, n2 = prev;
        while (n2.next != null) {
            tmp = n1.next;
            n1.next = n2;
            n1 = tmp;

            tmp = n2.next;
            n2.next = n1;
            n2 = tmp;
        }
    }
}
