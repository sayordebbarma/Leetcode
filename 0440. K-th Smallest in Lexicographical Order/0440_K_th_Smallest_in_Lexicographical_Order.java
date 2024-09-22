class Solution {
    public int findKthNumber(int n, int k) {
        int current = 1;
        k = k - 1;

        while (k > 0) {
            int steps = calculateSteps(n, current, current + 1);
            if (steps <= k) {
                current += 1;
                k -= steps;
            } else {
                current *= 10;
                k -= 1;
            }
        }

        return current;
    }

    private static int calculateSteps(int n, long current, long next) {
        int steps = 0;
        while (current <= n) {
            steps += Math.min(n + 1, next) - current;
            current *= 10;
            next *= 10;
        }
        return steps;
    }
}
