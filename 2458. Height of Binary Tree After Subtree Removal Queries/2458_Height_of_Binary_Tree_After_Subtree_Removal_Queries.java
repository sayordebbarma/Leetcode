/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Map<Integer, Integer> nodeDepth = new HashMap<>();
    Map<Integer, Integer> nodeHeight = new HashMap<>();
    
    Map<Integer, List<Integer>> depthHeights = new HashMap<>();
    
    public int[] treeQueries(TreeNode root, int[] queries) {
        computeDepthHeight(root, 0);
        
        for (int node : nodeHeight.keySet()) {
            int depth = nodeDepth.get(node);
            int height = nodeHeight.get(node);
            depthHeights.computeIfAbsent(depth, k -> new ArrayList<>()).add(height);
        }
        
        for (List<Integer> heights : depthHeights.values()) {
            heights.sort(Collections.reverseOrder());
        }
        
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int queryNode = queries[i];
            int depth = nodeDepth.get(queryNode);
            int height = nodeHeight.get(queryNode);
            
            List<Integer> heights = depthHeights.get(depth);
            int maxHeightExcludingQuery = heights.get(0) == height
                ? (heights.size() > 1 ? heights.get(1) : -1)
                : heights.get(0);
            
            answer[i] = (maxHeightExcludingQuery == -1) ? depth - 1 : depth + maxHeightExcludingQuery;
        }
        
        return answer;
    }
    
    private int computeDepthHeight(TreeNode node, int depth) {
        if (node == null) return -1;
        
        nodeDepth.put(node.val, depth);
        
        int leftHeight = computeDepthHeight(node.left, depth + 1);
        int rightHeight = computeDepthHeight(node.right, depth + 1);
        
        int height = Math.max(leftHeight, rightHeight) + 1;
        nodeHeight.put(node.val, height);
        
        return height;
    }
}
