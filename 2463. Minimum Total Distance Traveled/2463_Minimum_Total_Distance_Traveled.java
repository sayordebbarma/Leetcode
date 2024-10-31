class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        int n = robot.size();
        int m = factory.length;

        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> Integer.compare(a[0], b[0]));

        long[][] dp = new long[n + 1][m + 1];
        long MAX = 9_007_199_254_740_991L;

        for (long[] row : dp) Arrays.fill(row, MAX);
        dp[0][0] = 0;

        for (int j = 1; j <= m; j++) {
            int factoryPos = factory[j - 1][0];
            int factoryLimit = factory[j - 1][1];

            for (int i = 0; i <= n; i++) {
                dp[i][j] = dp[i][j - 1];

                long distance = 0;
                for (int k = 1; k <= Math.min(factoryLimit, i); k++) {
                    distance += Math.abs(factoryPos - robot.get(i - k));
                    dp[i][j] = Math.min(dp[i][j], dp[i - k][j - 1] + distance);
                }
            }
        }

        return dp[n][m];
    }
}
