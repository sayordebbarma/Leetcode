class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        Set<String> wallSet = new HashSet<>();
        Set<String> guardSet = new HashSet<>();
        Set<String> guardedSet = new HashSet<>();

        for (int[] wall : walls) {
            wallSet.add(wall[0] + "," + wall[1]);
        }
        for (int[] guard : guards) {
            guardSet.add(guard[0] + "," + guard[1]);
        }

        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        for (int[] guard : guards) {
            int x = guard[0], y = guard[1];

            for (int[] dir : directions) {
                int nx = x, ny = y;

                while (true) {
                    nx += dir[0];
                    ny += dir[1];

                    String pos = nx + "," + ny;

                    if (nx < 0 || ny < 0 || nx >= m || ny >= n || wallSet.contains(pos) || guardSet.contains(pos)) {
                        break;
                    }

                    guardedSet.add(pos);
                }
            }
        }

        int totalCells = m * n;
        int occupiedCells = wallSet.size() + guardSet.size() + guardedSet.size();

        return totalCells - occupiedCells;
    }
}
