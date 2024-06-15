class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        PriorityQueue<int[]> minCapitalHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < n; i++) {
            minCapitalHeap.offer(new int[] {profits[i], capital[i]});
        }

        for (int i = 0; i < k; i++) {
            while (!minCapitalHeap.isEmpty() && minCapitalHeap.peek()[1] <= w) {
                maxProfitHeap.offer(minCapitalHeap.poll()[0]);
            }

            if (maxProfitHeap.isEmpty()) break;

            w += maxProfitHeap.poll();
        }

        return w;
    }
}
