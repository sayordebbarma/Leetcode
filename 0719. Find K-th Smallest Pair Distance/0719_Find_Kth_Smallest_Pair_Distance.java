class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = nums[nums.length - 1] - nums[0];

        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = countPairs(nums, mid);
            
            if (count >= k) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    private static int countPairs(int[] nums, int target) {
        int count = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            while (nums[right] - nums[left] > target) {
                left++;
            }
            count += right - left;
        }
        return count;
    }
}
