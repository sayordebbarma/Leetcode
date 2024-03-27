class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int start = 0, end = 0, product = 1, count = 0;
        while (end < nums.length) {
            product *= nums[end++];
            while (product >= k && start < end) product /= nums[start++];
            count += end - start;
        }
        return count;
    }
}
