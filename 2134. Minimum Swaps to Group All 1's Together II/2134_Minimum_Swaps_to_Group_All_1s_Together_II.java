class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int countOnes = 0;
        
        for (int num : nums) {
            if (num == 1) countOnes++;
        }
        
        if (countOnes == 0 || countOnes == n) return 0;
        
        int[] extended = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            extended[i] = nums[i % n];
        }
        
        int minZeros = Integer.MAX_VALUE;
        int currentZeros = 0;
        
        for (int i = 0; i < countOnes; i++) {
            if (extended[i] == 0) currentZeros++;
        }
        minZeros = currentZeros;
        
        for (int i = countOnes; i < 2 * n; i++) {
            if (extended[i] == 0) currentZeros++;
            
            if (extended[i - countOnes] == 0) currentZeros--;
            
            minZeros = Math.min(minZeros, currentZeros);
        }
        
        return minZeros;
    }
}
