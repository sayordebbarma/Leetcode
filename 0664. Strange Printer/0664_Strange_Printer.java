class Solution {
    public int strangePrinter(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len <= n; i++) {
                int j = i + len - 1;
                dp[i][j] = len;
                
                for (int k = i + 1; k <= j; k++) {
                    int temp = dp[i][k - 1] + dp[k][j];
                    if (s.charAt(k - 1) == s.charAt(j)) temp--;
                    dp[i][j] = Math.min(dp[i][j], temp);
                }
            }
        }
        
        return dp[0][n - 1];
    }
}
