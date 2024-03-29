class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            root = q.poll();

            if(root.right != null) q.add(root.right);
            if(root.left != null) q.add(root.left);
        }

        return root.val;
    }
}
