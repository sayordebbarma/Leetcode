class Solution {
    public int[][] validArrangement(int[][] pairs) {
        Map<Integer, Stack<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, Integer> outDegree = new HashMap<>();
        
        for (int[] pair : pairs) {
            int start = pair[0], end = pair[1];
            graph.computeIfAbsent(start, k -> new Stack<>()).push(end);
            outDegree.put(start, outDegree.getOrDefault(start, 0) + 1);
            inDegree.put(end, inDegree.getOrDefault(end, 0) + 1);
        }
        
        int startNode = pairs[0][0];
        for (int node : graph.keySet()) {
            if (outDegree.getOrDefault(node, 0) > inDegree.getOrDefault(node, 0)) {
                startNode = node;
                break;
            }
        }
        
        LinkedList<Integer> eulerPath = new LinkedList<>();
        dfs(startNode, graph, eulerPath);
        
        int[][] result = new int[pairs.length][2];
        Iterator<Integer> it = eulerPath.iterator();
        int prev = it.next();
        int index = 0;
        while (it.hasNext()) {
            int curr = it.next();
            result[index++] = new int[] {prev, curr};
            prev = curr;
        }
        
        return result;
    }
    
    private void dfs(int node, Map<Integer, Stack<Integer>> graph, LinkedList<Integer> eulerPath) {
        Stack<Integer> neighbors = graph.getOrDefault(node, new Stack<>());
        while (!neighbors.isEmpty()) {
            int next = neighbors.pop();
            dfs(next, graph, eulerPath);
        }
        eulerPath.addFirst(node);
    }
}
