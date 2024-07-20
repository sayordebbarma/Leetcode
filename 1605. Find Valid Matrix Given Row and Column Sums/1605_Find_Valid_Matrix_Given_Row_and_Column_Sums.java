class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int numRows = rowSum.length;
        int numCols = colSum.length;
        int[][] matrix = new int[numRows][numCols];

        int i = 0, j = 0;
        while (i < numRows && j < numCols) {
            int minVal = Math.min(rowSum[i], colSum[j]);
            matrix[i][j] = minVal;
            
            rowSum[i] -= minVal;
            colSum[j] -= minVal;
            
            if (rowSum[i] == 0) i++;
            
            if (colSum[j] == 0) j++;
        }

        return matrix;
    }
}
