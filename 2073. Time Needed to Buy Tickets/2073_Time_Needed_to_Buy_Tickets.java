class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int ans = 0;

        for (int i = 0; i < tickets.length; ++i) {
            int minTickets = (i <= k) ? tickets[k] : tickets[k] - 1;
            ans += Math.min(tickets[i], minTickets);
        }

        return ans;
    }
}
