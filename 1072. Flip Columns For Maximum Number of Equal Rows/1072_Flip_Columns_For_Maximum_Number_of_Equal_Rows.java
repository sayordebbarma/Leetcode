class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> patternCount = new HashMap<>();

        for (int[] row : matrix) {
            StringBuilder pattern = new StringBuilder();
            StringBuilder flippedPattern = new StringBuilder();
            for (int cell : row) {
                pattern.append(cell);
                flippedPattern.append(1 - cell);
            }

            String patternKey = pattern.toString();
            String flippedKey = flippedPattern.toString();
            patternCount.put(patternKey, patternCount.getOrDefault(patternKey, 0) + 1);
            patternCount.put(flippedKey, patternCount.getOrDefault(flippedKey, 0) + 1);
        }

        int maxCount = 0;
        for (int count : patternCount.values()) {
            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }
}
