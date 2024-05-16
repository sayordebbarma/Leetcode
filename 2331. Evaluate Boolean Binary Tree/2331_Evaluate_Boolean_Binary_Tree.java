class Solution {
    public boolean evaluateTree(TreeNode root) {
        if (root == null) return false;
        
        if (root.left == null && root.right == null) return root.val == 1;
        
        boolean leftValue = evaluateTree(root.left);
        boolean rightValue = evaluateTree(root.right);
        
        if (root.val == 2) return leftValue || rightValue;
        else return leftValue && rightValue;
    }
}
