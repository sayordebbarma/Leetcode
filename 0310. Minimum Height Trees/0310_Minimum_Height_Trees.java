class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);

        List<Set<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new HashSet<>());
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        Queue<Integer> leaves = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (adjList.get(i).size() == 1) leaves.offer(i);
        }

        while (n > 2) {
            int leavesSize = leaves.size();
            n -= leavesSize;
            for (int i = 0; i < leavesSize; i++) {
                int leaf = leaves.poll();
                int neighbor = adjList.get(leaf).iterator().next();
                adjList.get(neighbor).remove(leaf);
                if (adjList.get(neighbor).size() == 1) leaves.offer(neighbor);
            }
        }

        return new ArrayList<>(leaves);
    }
}
