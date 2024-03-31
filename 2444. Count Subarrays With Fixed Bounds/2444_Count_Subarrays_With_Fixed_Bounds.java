class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int leftPtr = 0, rightPtr = 0;
        int lastMinIndex = -1, lastMaxIndex = -1;
        int n = nums.length;
        long count = 0L;
        
        while (rightPtr < n) {
            if (nums[rightPtr] < minK || nums[rightPtr] > maxK) {
                lastMinIndex = -1;
                lastMaxIndex = -1;
                leftPtr = rightPtr + 1;
            }
            if (nums[rightPtr] == minK) {
                lastMinIndex = rightPtr;
            }
            if (nums[rightPtr] == maxK) {
                lastMaxIndex = rightPtr;
            }
            if (lastMinIndex != -1 && lastMaxIndex != -1) {
                count += Math.min(lastMinIndex, lastMaxIndex) - leftPtr + 1; 
            }
            rightPtr++;
        }
        
        return count;
    }
}
