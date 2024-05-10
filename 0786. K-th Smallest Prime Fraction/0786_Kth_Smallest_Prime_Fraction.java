class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        final int n = arr.length;
        double l = 0;
        double r = 1.0;

        while (l < r) {
            double m = (l + r) / 2;
            double max_f = 0.0;
            int total = 0;
            int p = 0;
            int q = 0;

            for (int i = 0, j = 1; i < n - 1; ++i) {
                while (j < n && arr[i] > m * arr[j]) ++j;
                if (n == j) break;
                total += (n - j);
                final double f = (double) arr[i] / arr[j];
                if (f > max_f) {
                    p = i;
                    q = j;
                    max_f = f;
                }
            }

            if (total == k)
                return new int[]{arr[p], arr[q]};
            else if (total > k)
                r = m;
            else
                l = m;
        }

        return new int[]{};
    }
}
