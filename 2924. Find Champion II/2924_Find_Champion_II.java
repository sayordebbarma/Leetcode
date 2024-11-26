class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] indegree = new int[n];
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            indegree[v]++;
            graph.putIfAbsent(u, new HashSet<>());
            graph.get(u).add(v);
        }

        int potentialChampion = -1;
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                if (potentialChampion != -1) return -1;
                potentialChampion = i;
            }
        }

        if (potentialChampion == -1) return -1;

        Set<Integer> visited = new HashSet<>();
        dfs(potentialChampion, graph, visited);

        return visited.size() == n ? potentialChampion : -1;
    }

    private void dfs(int node, Map<Integer, Set<Integer>> graph, Set<Integer> visited) {
        visited.add(node);
        if (!graph.containsKey(node)) return;
        
        for (int neighbor : graph.get(node)) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, graph, visited);
            }
        }
    }
}
