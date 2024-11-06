class Solution {
    public boolean canSortArray(int[] nums) {
        int prevSetBits = 0, prevMax = Integer.MIN_VALUE, currMax = Integer.MIN_VALUE, currMin = Integer.MAX_VALUE;

        for (int num : nums) {
            int setBits = Integer.bitCount(num);
            if (setBits != prevSetBits) {
                if (prevMax > currMin) return false;
                
                prevSetBits = setBits;
                prevMax = currMax;
                currMax = currMin = num;
            } else {
                currMax = Math.max(currMax, num);
                currMin = Math.min(currMin, num);
            }
        }
        
        return prevMax <= currMin;
    }
}
