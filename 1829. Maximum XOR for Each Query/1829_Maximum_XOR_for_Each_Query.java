class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int maxXor = (1 << maximumBit) - 1;
        int[] answer = new int[n];
        
        int cumulativeXor = 0;
        for (int num : nums) {
            cumulativeXor ^= num;
        }

        for (int i = 0; i < n; i++) {
            answer[i] = cumulativeXor ^ maxXor;            
            cumulativeXor ^= nums[n - 1 - i];
        }
        
        return answer;
    }
}
