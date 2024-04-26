class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int[] dp = new int[n];
        System.arraycopy(grid[0], 0, dp, 0, n);
        
        for (int i = 1; i < n; i++) {
            int[] nextRow = new int[n];
            
            for (int j = 0; j < n; j++) {
                int minPrev = Integer.MAX_VALUE;
                
                for (int k = 0; k < n; k++) {
                    if (k != j) {
                        minPrev = Math.min(minPrev, dp[k]);
                    }
                }
                
                nextRow[j] = grid[i][j] + minPrev;
            }
            
            System.arraycopy(nextRow, 0, dp, 0, n);
        }
        
        int minPathSum = Integer.MAX_VALUE;
        for (int num : dp) {
            minPathSum = Math.min(minPathSum, num);
        }
        
        return minPathSum;
    }
}
