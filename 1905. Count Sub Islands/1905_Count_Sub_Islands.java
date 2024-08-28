class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length, n = grid1[0].length;
        int count = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    if (isSubIsland(grid1, grid2, i, j)) count++;
                }
            }
        }
        return count;
    }
    
    private boolean isSubIsland(int[][] grid1, int[][] grid2, int i, int j) {
        int m = grid1.length, n = grid1[0].length;
        
        if (i < 0 || i >= m || j < 0 || j >= n || grid2[i][j] == 0) return true;
        
        if (grid1[i][j] == 0) return false;
        
        grid2[i][j] = 0;
        
        boolean isSub = true;
        isSub &= isSubIsland(grid1, grid2, i + 1, j);
        isSub &= isSubIsland(grid1, grid2, i - 1, j);
        isSub &= isSubIsland(grid1, grid2, i, j + 1);
        isSub &= isSubIsland(grid1, grid2, i, j - 1);
        
        return isSub;
    }
}
