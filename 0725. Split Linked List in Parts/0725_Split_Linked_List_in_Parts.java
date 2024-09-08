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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] parts = new ListNode[k];
        int length = 0;
        ListNode temp = head;

        while (temp != null) {
            length++;
            temp = temp.next;
        }

        int partSize = length / k;
        int extraNodes = length % k;

        ListNode current = head;
        for (int i = 0; i < k; i++) {
            parts[i] = current;
            int currentPartSize = partSize + (extraNodes > 0 ? 1 : 0);
            extraNodes--;

            for (int j = 1; j < currentPartSize && current != null; j++) {
                current = current.next;
            }

            if (current != null) {
                ListNode nextPart = current.next;
                current.next = null;
                current = nextPart;
            }
        }

        return parts;
    }
}
