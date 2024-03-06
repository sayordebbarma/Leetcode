public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode tortoise = head, hare = head;

        while(hare!=null && hare.next!=null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
            if(tortoise == hare) return true;
        }

        return false;
    }
}
