class Solution {
    public int countPairs(TreeNode root, int distance) {
        if (root == null) return 0;
        int[] result = new int[1];
        dfs(root, distance, result);
        return result[0];
    }

    private int[] dfs(TreeNode node, int distance, int[] result) {
        if (node == null) return new int[distance + 1];
        
        if (node.left == null && node.right == null) {
            int[] leaves = new int[distance + 1];
            leaves[1] = 1;
            return leaves;
        }
        
        int[] leftLeaves = dfs(node.left, distance, result);
        int[] rightLeaves = dfs(node.right, distance, result);

        for (int i = 1; i <= distance; i++) {
            for (int j = 1; j <= distance - i; j++) {
                result[0] += leftLeaves[i] * rightLeaves[j];
            }
        }

        int[] currentLeaves = new int[distance + 1];
        for (int i = 1; i < distance; i++) {
            currentLeaves[i + 1] = leftLeaves[i] + rightLeaves[i];
        }
        
        return currentLeaves;
    }
}
