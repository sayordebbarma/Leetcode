class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 0});

        int[][] distances = new int[n + 1][2];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(distances[i], Integer.MAX_VALUE);
        }
        distances[1][0] = 0;

        while (!queue.isEmpty()) {
            int[] nodeData = queue.poll();
            int currentNode = nodeData[0], currentDistance = nodeData[1];

            for (int neighbor : graph[currentNode]) {
                int newDistance = currentDistance + 1;
                if (newDistance < distances[neighbor][0]) {
                    distances[neighbor][1] = distances[neighbor][0];
                    distances[neighbor][0] = newDistance;
                    queue.add(new int[]{neighbor, newDistance});
                } else if (newDistance > distances[neighbor][0] && newDistance < distances[neighbor][1]) {
                    distances[neighbor][1] = newDistance;
                    queue.add(new int[]{neighbor, newDistance});
                }
            }
        }

        int totalTime = 0;
        for (int i = 0; i < distances[n][1]; i++) {
            totalTime += time;
            if (i < distances[n][1] - 1 && (totalTime / change) % 2 == 1) {
                totalTime = (totalTime / change + 1) * change;
            }
        }
        return totalTime;
    }
}
