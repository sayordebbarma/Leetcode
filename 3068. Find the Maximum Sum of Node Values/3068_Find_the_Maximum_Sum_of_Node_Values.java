class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long totalSum = 0;
        int alteredCount = 0;
        int smallestDiff = Integer.MAX_VALUE;

        for (final int value : nums) {
            int alteredValue = value ^ k;
            if (alteredValue > value) {
                alteredCount++;
                totalSum += alteredValue;
            } else {
                totalSum += value;
            }
            smallestDiff = Math.min(smallestDiff, Math.abs(value - alteredValue));
        }

        if (alteredCount % 2 == 0) return totalSum;
        else return totalSum - smallestDiff;
    }
}
