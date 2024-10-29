class Solution {
    public int maxMoves(int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;

        int[][] dp = new int[m][n];

        int maxMoves = 0;

        for (int j = n - 2; j >= 0; --j) {
            for (int i = 0; i < m; ++i) {
                if (grid[i][j + 1] > grid[i][j]) {
                    dp[i][j] = 1 + dp[i][j + 1];
                }
                if (i > 0 && grid[i - 1][j + 1] > grid[i][j]) {
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i - 1][j + 1]);
                }
                if (i + 1 < m && grid[i + 1][j + 1] > grid[i][j]) {
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i + 1][j + 1]);
                }
            }
        }

        for (int i = 0; i < m; ++i) {
            maxMoves = Math.max(maxMoves, dp[i][0]);
        }

        return maxMoves;
    }
}
