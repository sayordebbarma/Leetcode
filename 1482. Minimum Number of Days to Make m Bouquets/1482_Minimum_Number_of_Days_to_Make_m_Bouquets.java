class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if (n < (long) m * k) return -1;

        int left = Arrays.stream(bloomDay).min().getAsInt();
        int right = Arrays.stream(bloomDay).max().getAsInt();

        while (left < right) {
            int mid = (left + right) / 2;
            if (canFormBouquets(bloomDay, m, k, mid)) right = mid;
            else left = mid + 1;
        }

        return left;
    }

    private static boolean canFormBouquets(int[] bloomDay, int m, int k, int days) {
        int bouquets = 0;
        int consecutiveFlowers = 0;

        for (int day : bloomDay) {
            if (day <= days) {
                consecutiveFlowers++;
                if (consecutiveFlowers == k) {
                    bouquets++;
                    consecutiveFlowers = 0;
                }
            } else {
                consecutiveFlowers = 0;
            }

            if (bouquets >= m) return true;
        }

        return false;
    }
}
