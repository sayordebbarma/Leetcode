class Solution {
    private static List<Integer> topologicalSort(int n, List<List<Integer>> adjList) {
        int[] inDegree = new int[n];
        for (List<Integer> neighbors : adjList) {
            for (int neighbor : neighbors) {
                inDegree[neighbor]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> topoOrder = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            topoOrder.add(node);

            for (int neighbor : adjList.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        return topoOrder;
    }

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
        }

        List<Integer> topoOrder = topologicalSort(n, adjList);
        List<Set<Integer>> ancestors = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            ancestors.add(new HashSet<>());
        }

        for (int node : topoOrder) {
            for (int neighbor : adjList.get(node)) {
                ancestors.get(neighbor).add(node);
                ancestors.get(neighbor).addAll(ancestors.get(node));
            }
        }

        List<List<Integer>> result = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            List<Integer> sortedAncestors = new ArrayList<>(ancestors.get(i));
            Collections.sort(sortedAncestors);
            result.add(sortedAncestors);
        }

        return result;
    }
}
