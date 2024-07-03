class Solution {
    public int minDifference(int[] nums) {
        if (nums.length <= 4) return 0;
        
        Arrays.sort(nums);

        int n = nums.length;
        int case1 = nums[n - 1] - nums[3];
        int case2 = nums[n - 2] - nums[2];
        int case3 = nums[n - 3] - nums[1];
        int case4 = nums[n - 4] - nums[0];

        return Math.min(Math.min(case1, case2), Math.min(case3, case4));
    }
}
