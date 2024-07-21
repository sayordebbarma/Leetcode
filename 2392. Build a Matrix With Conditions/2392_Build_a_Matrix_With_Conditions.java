class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[][] matrix = new int[k][k];
        int[] rowOrder = topologicalSort(k, rowConditions);
        int[] colOrder = topologicalSort(k, colConditions);

        if (rowOrder == null || colOrder == null) return new int[0][0];

        Map<Integer, Integer> rowIndexMap = new HashMap<>();
        Map<Integer, Integer> colIndexMap = new HashMap<>();

        for (int i = 0; i < k; i++) {
            rowIndexMap.put(rowOrder[i], i);
            colIndexMap.put(colOrder[i], i);
        }

        for (int i = 1; i <= k; i++) {
            matrix[rowIndexMap.get(i)][colIndexMap.get(i)] = i;
        }

        return matrix;
    }

    private int[] topologicalSort(int k, int[][] conditions) {
        List<Integer>[] graph = new ArrayList[k + 1];
        int[] inDegree = new int[k + 1];
        
        for (int i = 1; i <= k; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] condition : conditions) {
            int u = condition[0];
            int v = condition[1];
            graph[u].add(v);
            inDegree[v]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= k; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }

        int[] order = new int[k];
        int index = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            order[index++] = node;

            for (int neighbor : graph[node]) {
                if (--inDegree[neighbor] == 0) queue.add(neighbor);
            }
        }

        return index == k ? order : null;
    }
}
