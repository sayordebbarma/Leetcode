class Solution {
    public int getMaximumGold(int[][] grid) {
        int maxGold = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] != 0) {
                    maxGold = Math.max(maxGold, collectGold(grid, row, col));
                }
            }
        }

        return maxGold;
    }

    private int collectGold(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
            return 0;
        }

        int currentGold = grid[row][col];
        grid[row][col] = 0;

        int up = collectGold(grid, row - 1, col);
        int down = collectGold(grid, row + 1, col);
        int left = collectGold(grid, row, col - 1);
        int right = collectGold(grid, row, col + 1);

        grid[row][col] = currentGold;

        return currentGold + Math.max(Math.max(up, down), Math.max(left, right));
    }
}
