class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lca = findLCA(root, startValue, destValue);
        
        StringBuilder pathToStart = new StringBuilder();
        findPath(lca, startValue, pathToStart);
        
        StringBuilder pathToDest = new StringBuilder();
        findPath(lca, destValue, pathToDest);
        
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < pathToStart.length(); i++) {
            result.append('U');
        }
        
        result.append(pathToDest);
        
        return result.toString();
    }
    
    private TreeNode findLCA(TreeNode root, int p, int q) {
        if (root == null || root.val == p || root.val == q) return root;
        
        TreeNode left = findLCA(root.left, p, q);
        TreeNode right = findLCA(root.right, p, q);
        if (left != null && right != null) return root;
        
        return left != null ? left : right;
    }
    
    private boolean findPath(TreeNode root, int val, StringBuilder path) {
        if (root == null) return false;
        
        if (root.val == val) return true;

        path.append('L');
        if (findPath(root.left, val, path)) return true;
        path.deleteCharAt(path.length() - 1);
        
        path.append('R');
        if (findPath(root.right, val, path)) return true;
        path.deleteCharAt(path.length() - 1);
        
        return false;
    }
}
