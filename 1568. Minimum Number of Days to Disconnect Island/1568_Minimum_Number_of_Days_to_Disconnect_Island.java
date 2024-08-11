class Solution {
    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public int minDays(int[][] grid) {
        if (isDisconnected(grid)) return 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    if (isDisconnected(grid)) return 1;
                    
                    grid[i][j] = 1;
                }
            }
        }
        
        return 2;
    }
    
    private boolean isDisconnected(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        
        int islands = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    islands++;
                    if (islands > 1) return true;
                    dfs(grid, visited, i, j);
                }
            }
        }
        return islands != 1;
    }
    
    private void dfs(int[][] grid, boolean[][] visited, int i, int j) {
        int m = grid.length, n = grid[0].length;
        visited[i][j] = true;
        
        for (int[] dir : directions) {
            int newRow = i + dir[0];
            int newCol = j + dir[1];
            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && 
                grid[newRow][newCol] == 1 && !visited[newRow][newCol]) {
                dfs(grid, visited, newRow, newCol);
            }
        }
    }
}
