class Solution {
    public String smallestFromLeaf(TreeNode root) {
        return dfs(root, "");
    }

    private String dfs(TreeNode node, String suffix) {
        if (node == null) return suffix;

        suffix = (char) ('a' + node.val) + suffix;

        if (node.left == null && node.right == null) return suffix;

        String leftSuffix = node.left != null ? dfs(node.left, suffix) : "";
        String rightSuffix = node.right != null ? dfs(node.right, suffix) : "";

        if (!leftSuffix.isEmpty() && !rightSuffix.isEmpty())
            return leftSuffix.compareTo(rightSuffix) <= 0 ? leftSuffix : rightSuffix;
        else
            return !leftSuffix.isEmpty() ? leftSuffix : rightSuffix;
    }
}
