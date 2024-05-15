class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int[][] distToThief = calculateDistancesToThief(grid);
        int left = 0;
        int right = grid.size() * 2;

        while (left < right) {
            int mid = (left + right) / 2;
            if (isValidPath(distToThief, mid))
                left = mid + 1;
            else
                right = mid;
        }

        return left - 1;
    }

    private boolean isValidPath(int[][] distToThief, int safeness) {
        if (distToThief[0][0] < safeness)
            return false;

        int n = distToThief.length;
        Queue<Pair<Integer, Integer>> queue = new ArrayDeque<>(Arrays.asList(new Pair<>(0, 0)));
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int i = queue.peek().getKey();
            int j = queue.poll().getValue();
            if (distToThief[i][j] < safeness)
                continue;
            if (i == n - 1 && j == n - 1)
                return true;
            for (int[] dir : directions) {
                int x = i + dir[0];
                int y = j + dir[1];
                if (x < 0 || x == n || y < 0 || y == n)
                    continue;
                if (visited[x][y])
                    continue;
                queue.offer(new Pair<>(x, y));
                visited[x][y] = true;
            }
        }

        return false;
    }

    private int[][] calculateDistancesToThief(List<List<Integer>> grid) {
        int n = grid.size();
        int[][] distances = new int[n][n];
        Queue<Pair<Integer, Integer>> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];

        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j)
                if (grid.get(i).get(j) == 1) {
                    queue.offer(new Pair<>(i, j));
                    visited[i][j] = true;
                }

        for (int dist = 0; !queue.isEmpty(); ++dist) {
            for (int sz = queue.size(); sz > 0; --sz) {
                int i = queue.peek().getKey();
                int j = queue.poll().getValue();
                distances[i][j] = dist;
                for (int[] dir : directions) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if (x < 0 || x == n || y < 0 || y == n)
                        continue;
                    if (visited[x][y])
                        continue;
                    queue.offer(new Pair<>(x, y));
                    visited[x][y] = true;
                }
            }
        }

        return distances;
    }

    private static final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
}
