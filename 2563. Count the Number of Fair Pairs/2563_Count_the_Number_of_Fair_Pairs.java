class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long count = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = findLowerBound(nums, i + 1, lower - nums[i]);
            int k = findUpperBound(nums, i + 1, upper - nums[i]);
            count += Math.max(0, k - j + 1);
        }
        return count;
    }

    private int findLowerBound(int[] nums, int start, int target) {
        int left = start, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }

    private int findUpperBound(int[] nums, int start, int target) {
        int left = start, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) left = mid + 1;
            else right = mid - 1;
        }
        return right;
    }
}
