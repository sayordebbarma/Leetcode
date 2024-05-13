class Solution {
    public int matrixScore(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        int result = 0;
        
        // Step 1: Toggle rows to ensure the first element of each row is 1
        for (int[] row : grid) {
            if (row[0] == 0) {
                toggleRow(row);
            }
        }
        
        // Step 2: Toggle columns if the number of 1's is less than or equal to the number of 0's
        for (int col = 0; col < cols; col++) {
            int onesCount = countOnes(grid, col);
            if (onesCount <= rows / 2) {
                toggleColumn(grid, col);
            }
        }
        
        // Step 3: Calculate the score
        for (int[] row : grid) {
            result += binaryToDecimal(row);
        }
        
        return result;
    }
    
    private void toggleRow(int[] row) {
        for (int i = 0; i < row.length; i++) {
            row[i] = 1 - row[i];
        }
    }
    
    private void toggleColumn(int[][] grid, int col) {
        for (int[] row : grid) {
            row[col] = 1 - row[col];
        }
    }
    
    private int countOnes(int[][] grid, int col) {
        int count = 0;
        for (int[] row : grid) {
            if (row[col] == 1) {
                count++;
            }
        }
        return count;
    }
    
    private int binaryToDecimal(int[] binary) {
        int decimal = 0;
        for (int i = 0; i < binary.length; i++) {
            decimal += binary[i] * Math.pow(2, binary.length - 1 - i);
        }
        return decimal;
    }
}
