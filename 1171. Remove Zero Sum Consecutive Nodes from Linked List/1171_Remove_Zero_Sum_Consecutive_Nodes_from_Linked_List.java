class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        Map<Integer, ListNode> prefixSumMap = new HashMap<>();
        int prefixSum = 0;
        for (ListNode current = dummy; current != null; current = current.next) {
            prefixSum += current.val;
            prefixSumMap.put(prefixSum, current);
        }

        prefixSum = 0;
        for (ListNode current = dummy; current != null; current = current.next) {
            prefixSum += current.val;
            current.next = prefixSumMap.get(prefixSum).next;
        }

        return dummy.next;
    }
}
