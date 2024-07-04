class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int sum = 0;

        while (head != null) {
            if (head.val == 0) {
                if (sum != 0) {
                    current.next = new ListNode(sum);
                    current = current.next;
                    sum = 0;
                }
            } else {
                sum += head.val;
            }
            head = head.next;
        }

        return dummy.next;
    }
}
