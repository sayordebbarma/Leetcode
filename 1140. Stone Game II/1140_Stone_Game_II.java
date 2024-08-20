class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n + 1];
        int[] suffixSum = new int[n];
        
        suffixSum[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = piles[i] + suffixSum[i + 1];
        }
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        return helper(piles, 0, 1, dp, suffixSum);
    }
    
    private int helper(int[] piles, int i, int M, int[][] dp, int[] suffixSum) {
        if (i == piles.length) return 0;
        
        if (dp[i][M] != -1) return dp[i][M];
        
        int maxStones = 0;
        for (int X = 1; X <= 2 * M && i + X <= piles.length; X++) {
            int stonesTaken = suffixSum[i] - (i + X < piles.length ? helper(piles, i + X, Math.max(M, X), dp, suffixSum) : 0);
            maxStones = Math.max(maxStones, stonesTaken);
        }
        
        dp[i][M] = maxStones;
        return dp[i][M];
    }
}
