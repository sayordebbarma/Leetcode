class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long totalCost = 0;

        long[][] distance = new long[26][26];

        for (long[] row : distance) {
            Arrays.fill(row, Long.MAX_VALUE);
        }

        for (int i = 0; i < cost.length; ++i) {
            int from = original[i] - 'a';
            int to = changed[i] - 'a';
            distance[from][to] = Math.min(distance[from][to], cost[i]);
        }

        for (int k = 0; k < 26; ++k) {
            for (int i = 0; i < 26; ++i) {
                if (distance[i][k] < Long.MAX_VALUE) {
                    for (int j = 0; j < 26; ++j) {
                        if (distance[k][j] < Long.MAX_VALUE) {
                            distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                        }
                    }
                }
            }
        }

        for (int i = 0; i < source.length(); ++i) {
            if (source.charAt(i) == target.charAt(i)) continue;

            int from = source.charAt(i) - 'a';
            int to = target.charAt(i) - 'a';

            if (distance[from][to] == Long.MAX_VALUE) return -1;

            totalCost += distance[from][to];
        }

        return totalCost;
    }
}
