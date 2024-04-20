class Solution {
    public int[][] findFarmland(int[][] land) {
        List<int[]> farmlandBlocks = new ArrayList<>();
        int rows = land.length;
        int cols = land[0].length;

        for (int r = 0; r < rows; ++r) {
            for (int c = 0; c < cols; ++c) {
                if (land[r][c] == 0 || (c > 0 && land[r][c - 1] == 1) || (r > 0 && land[r - 1][c] == 1)) {
                    continue;
                }

                int bottomR = r;
                int rightC = c;

                while (bottomR + 1 < rows && land[bottomR + 1][c] == 1) {
                    ++bottomR;
                }

                while (rightC + 1 < cols && land[bottomR][rightC + 1] == 1) {
                    ++rightC;
                }

                farmlandBlocks.add(new int[] {r, c, bottomR, rightC});
            }
        }

        return farmlandBlocks.toArray(new int[farmlandBlocks.size()][4]);
    }
}
