class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodes = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        for (int[] desc : descriptions) {
            int parentVal = desc[0];
            int childVal = desc[1];
            boolean isLeft = desc[2] == 1;

            TreeNode parent = nodes.getOrDefault(parentVal, new TreeNode(parentVal));
            nodes.put(parentVal, parent);

            TreeNode child = nodes.getOrDefault(childVal, new TreeNode(childVal));
            nodes.put(childVal, child);

            if (isLeft) parent.left = child;
            else parent.right = child;

            children.add(childVal);
        }

        TreeNode root = null;
        for (int[] desc : descriptions) {
            int parentVal = desc[0];
            if (!children.contains(parentVal)) {
                root = nodes.get(parentVal);
                break;
            }
        }

        return root;
    }
}
