class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int maxLength = 0;
        Map<Integer, Integer> elementCount = new HashMap<>();

        for (int start = 0, end = 0; end < nums.length; ++end) {
            elementCount.merge(nums[end], 1, Integer::sum);
            while (elementCount.get(nums[end]) == k + 1)
                elementCount.merge(nums[start++], -1, Integer::sum);
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}
