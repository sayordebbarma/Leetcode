class Solution {
    public int largestCombination(int[] candidates) {
        int[] bitCount = new int[25]; 

        for (int num : candidates) {
            for (int i = 0; i < 25; i++) {
                if ((num & (1 << i)) != 0) bitCount[i]++;
            }
        }
        
        int maxCombinationSize = 0;
        for (int count : bitCount) {
            maxCombinationSize = Math.max(maxCombinationSize, count);
        }
        
        return maxCombinationSize;
    }
}
