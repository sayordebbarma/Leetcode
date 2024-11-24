class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        long totalSum = 0;
        int negativeCount = 0;
        int smallestAbsValue = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int value = matrix[i][j];
                totalSum += Math.abs(value);
                if (value < 0) negativeCount++;
                
                smallestAbsValue = Math.min(smallestAbsValue, Math.abs(value));
            }
        }

        if (negativeCount % 2 != 0) totalSum -= 2 * smallestAbsValue;

        return totalSum;
    }
}
