class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] remainderCount = new int[k];

        for (int num : arr) {
            int remainder = ((num % k) + k) % k;
            remainderCount[remainder]++;
        }

        for (int r = 1; r < k; r++) {
            if (remainderCount[r] != remainderCount[k - r]) return false;
        }

        return remainderCount[0] % 2 == 0;
    }
}
