class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i <= rows - 3; i++) {
            for (int j = 0; j <= cols - 3; j++) {
                if (isMagic(grid, i, j)) count++;
            }
        }
        return count;
    }

    private boolean isMagic(int[][] grid, int x, int y) {
        boolean[] seen = new boolean[10];
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                int num = grid[i][j];
                if (num < 1 || num > 9 || seen[num]) return false;
                
                seen[num] = true;
            }
        }

        int sum1 = grid[x][y] + grid[x][y + 1] + grid[x][y + 2];
        int sum2 = grid[x + 1][y] + grid[x + 1][y + 1] + grid[x + 1][y + 2];
        int sum3 = grid[x + 2][y] + grid[x + 2][y + 1] + grid[x + 2][y + 2];

        int sum4 = grid[x][y] + grid[x + 1][y] + grid[x + 2][y];
        int sum5 = grid[x][y + 1] + grid[x + 1][y + 1] + grid[x + 2][y + 1];
        int sum6 = grid[x][y + 2] + grid[x + 1][y + 2] + grid[x + 2][y + 2];

        int diag1 = grid[x][y] + grid[x + 1][y + 1] + grid[x + 2][y + 2];
        int diag2 = grid[x][y + 2] + grid[x + 1][y + 1] + grid[x + 2][y];

        return sum1 == 15 && sum2 == 15 && sum3 == 15 && sum4 == 15 &&
               sum5 == 15 && sum6 == 15 && diag1 == 15 && diag2 == 15;
    }
}
