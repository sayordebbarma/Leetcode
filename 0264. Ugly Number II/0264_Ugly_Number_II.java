class Solution {
    public int nthUglyNumber(int n) {
        if (n <= 0) return 0;

        PriorityQueue<Long> heap = new PriorityQueue<>();
        HashSet<Long> seen = new HashSet<>();

        heap.add(1L);
        seen.add(1L);

        long ugly = 0;

        for (int i = 0; i < n; i++) {
            ugly = heap.poll();

            for (int factor : new int[] {2, 3, 5}) {
                long newUgly = ugly * factor;
                if (seen.add(newUgly)) heap.add(newUgly);
            }
        }

        return (int) ugly;
    }
}
