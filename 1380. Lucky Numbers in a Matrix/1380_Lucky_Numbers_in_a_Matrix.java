class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[] rowMin = new int[m];
        int[] colMax = new int[n];
        
        for (int i = 0; i < m; i++) {
            rowMin[i] = matrix[i][0];
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] < rowMin[i]) {
                    rowMin[i] = matrix[i][j];
                }
            }
        }
        
        for (int j = 0; j < n; j++) {
            colMax[j] = matrix[0][j];
            for (int i = 1; i < m; i++) {
                if (matrix[i][j] > colMax[j]) {
                    colMax[j] = matrix[i][j];
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == rowMin[i] && matrix[i][j] == colMax[j]) {
                    result.add(matrix[i][j]);
                }
            }
        }
        
        return result;
    }
}
