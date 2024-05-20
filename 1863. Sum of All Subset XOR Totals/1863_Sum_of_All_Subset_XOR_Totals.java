class Solution {
    public int subsetXORSum(int[] nums) {
        return subsetXORSumHelper(nums, 0, 0);
    }

    private static int subsetXORSumHelper(int[] nums, int index, int currXOR) {
        if (index == nums.length) return currXOR;

        int includeCurrent = subsetXORSumHelper(nums, index + 1, currXOR ^ nums[index]);
        int excludeCurrent = subsetXORSumHelper(nums, index + 1, currXOR);

        return includeCurrent + excludeCurrent;
    }
}
