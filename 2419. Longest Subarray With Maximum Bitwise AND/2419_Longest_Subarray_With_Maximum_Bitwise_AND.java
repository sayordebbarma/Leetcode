class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0, length = 0, maxLength = 0;

        for (int num : nums) {
            if (num > max) max = num;
        }

        for (int num : nums) {
            if (num == max) {
                length++;
                maxLength = Math.max(maxLength, length);
            } else {
                length = 0;
            }
        }

        return maxLength;
    }
}
