class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        long maxSum = 0;
        long currentSum = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
            currentSum += nums[i];

            if (i >= k) {
                int left = nums[i - k];
                currentSum -= left;
                countMap.put(left, countMap.get(left) - 1);
                if (countMap.get(left) == 0) countMap.remove(left);
            }

            if (countMap.size() == k) maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
