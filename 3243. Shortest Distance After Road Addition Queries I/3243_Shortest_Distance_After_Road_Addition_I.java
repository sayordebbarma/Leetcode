class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int[] result = new int[queries.length];
        int[] distances = new int[n];
        List<Integer>[] adjacencyList = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            distances[i] = i;
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            adjacencyList[i].add(i + 1);
        }

        for (int i = 0; i < queries.length; i++) {
            int source = queries[i][0];
            int destination = queries[i][1];
            adjacencyList[source].add(destination);

            if (distances[source] + 1 < distances[destination]) {
                distances[destination] = distances[source] + 1;
                performBFS(adjacencyList, destination, distances);
            }

            result[i] = distances[n - 1];
        }

        return result;
    }

    private void performBFS(List<Integer>[] adjacencyList, int startNode, int[] distances) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startNode);

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            for (int neighbor : adjacencyList[currentNode]) {
                if (distances[currentNode] + 1 < distances[neighbor]) {
                    distances[neighbor] = distances[currentNode] + 1;
                    queue.offer(neighbor);
                }
            }
        }
    }
}
