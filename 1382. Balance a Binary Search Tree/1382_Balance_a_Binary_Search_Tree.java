class Solution {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        inOrderTraversal(root, nodes);
        return buildBalancedBST(nodes, 0, nodes.size() - 1);
    }
    
    private void inOrderTraversal(TreeNode root, List<Integer> nodes) {
        if (root == null) return;
        
        inOrderTraversal(root.left, nodes);
        nodes.add(root.val);
        inOrderTraversal(root.right, nodes);
    }
    
    private TreeNode buildBalancedBST(List<Integer> nodes, int start, int end) {
        if (start > end) return null;
        
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(nodes.get(mid));
        node.left = buildBalancedBST(nodes, start, mid - 1);
        node.right = buildBalancedBST(nodes, mid + 1, end);
        return node;
    }
}
