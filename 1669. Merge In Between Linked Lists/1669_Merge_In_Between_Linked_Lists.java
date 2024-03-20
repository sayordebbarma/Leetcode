class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode current = list1, nodeA = null, nodeB = null;
        int index = 0;

        while (current != null) {
            if (index == a - 1) {
                nodeA = current;
            } else if (index == b + 1) {
                nodeB = current;
                break; // No need to continue traversal beyond b+1
            }
            current = current.next;
            index++;
        }

        nodeA.next = list2;
        getTail(list2).next = nodeB;
        return list1;
    }

    public ListNode getTail(ListNode node) {
        while (node.next != null) {
            node = node.next;
        }
        return node;
    }
}
