class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        height(root, diameter);
        return diameter[0];
    }

    public int height(TreeNode node, int[] diameter) {
        if(node==null) return 0;

        int leftHeight = height(node.left, diameter);
        int rightHeight = height(node.right, diameter);

        diameter[0] = Math.max(diameter[0], leftHeight+rightHeight);

        return 1+Math.max(leftHeight, rightHeight);
    }
}
