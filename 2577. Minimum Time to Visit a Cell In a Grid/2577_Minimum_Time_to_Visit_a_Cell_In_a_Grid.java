class Solution {
    public int minimumTime(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        if (grid[0][1] > 1 && grid[1][0] > 1) return -1;

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        heap.add(new int[]{0, 0, 0});

        boolean[][] visited = new boolean[rows][cols];
        visited[0][0] = true;

        while (!heap.isEmpty()) {
            int[] current = heap.poll();
            int time = current[0], r = current[1], c = current[2];

            if (r == rows - 1 && c == cols - 1) return time;

            for (int[] dir : directions) {
                int nr = r + dir[0], nc = c + dir[1];
                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols || visited[nr][nc]) continue;

                int waitTime = (grid[nr][nc] - time) % 2 == 0 ? 1 : 0;
                int arrivalTime = Math.max(time + 1, grid[nr][nc] + waitTime);

                heap.offer(new int[]{arrivalTime, nr, nc});
                visited[nr][nc] = true;
            }
        }
        return -1;
    }
}
