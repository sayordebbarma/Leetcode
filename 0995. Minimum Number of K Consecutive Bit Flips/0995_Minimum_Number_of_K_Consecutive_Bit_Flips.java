class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int[] flip = new int[n];
        int flipCount = 0;
        int res = 0;

        for (int i = 0; i < n; i++) {
            if (i >= k) flipCount ^= flip[i - k];
            if (flipCount % 2 == nums[i]) {
                if (i + k > n) return -1;
                flip[i] = 1;
                flipCount ^= 1;
                res++;
            }
        }
        return res;
    }
}
