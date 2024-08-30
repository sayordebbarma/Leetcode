class Solution {
    private static final int MAX_VALUE = 2_000_000_000;

    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        List<List<int[]>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            if (w != -1) {
                adjList.get(u).add(new int[]{v, w});
                adjList.get(v).add(new int[]{u, w});
            }
        }
        int currentDist = calculateShortestPath(adjList, source, destination);
        if (currentDist < target) return new int[0][];
        if (currentDist == target) {
            for (int[] edge : edges) if (edge[2] == -1) edge[2] = MAX_VALUE;
            return edges;
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1], w = edges[i][2];
            if (w == -1) {
                edges[i][2] = 1;
                adjList.get(u).add(new int[]{v, 1});
                adjList.get(v).add(new int[]{u, 1});
                currentDist = calculateShortestPath(adjList, source, destination);
                if (currentDist <= target) {
                    edges[i][2] += target - currentDist;
                    for (int j = i + 1; j < edges.length; j++) if (edges[j][2] == -1) edges[j][2] = MAX_VALUE;
                    return edges;
                }
            }
        }
        return new int[0][];
    }

    private int calculateShortestPath(List<List<int[]>> adjList, int start, int end) {
        int[] minDist = new int[adjList.size()];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minDist[start] = 0;
        pq.offer(new int[]{0, start});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int dist = current[0], node = current[1];
            if (dist > minDist[node]) continue;
            for (int[] neighbor : adjList.get(node)) {
                int nextNode = neighbor[0], weight = neighbor[1];
                if (dist + weight < minDist[nextNode]) {
                    minDist[nextNode] = dist + weight;
                    pq.offer(new int[]{minDist[nextNode], nextNode});
                }
            }
        }
        return minDist[end];
    }
}
