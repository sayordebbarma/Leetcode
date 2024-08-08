class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] result = new int[rows * cols][2];
        int[] directions = {0, 1, 0, -1, 0};
        int step = 0, index = 0;

        result[index++] = new int[]{rStart, cStart};

        while (index < rows * cols) {
            for (int i = 0; i < 4; i++) {
                if (i % 2 == 0) step++;

                for (int j = 0; j < step; j++) {
                    rStart += directions[i];
                    cStart += directions[i + 1];
                    if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                        result[index++] = new int[]{rStart, cStart};
                    }
                }
            }
        }

        return result;
    }
}
