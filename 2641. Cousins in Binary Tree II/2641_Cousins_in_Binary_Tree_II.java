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
    public TreeNode replaceValueInTree(TreeNode root) {
        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        root.val = 0;
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int totalSum = 0;
            List<TreeNode> nodesAtCurrentLevel = new ArrayList<>();
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                nodesAtCurrentLevel.add(node);
                if (node.left != null) totalSum += node.left.val;
                if (node.right != null) totalSum += node.right.val;
            }
            
            for (TreeNode node : nodesAtCurrentLevel) {
                int siblingSum = 0;
                if (node.left != null) siblingSum += node.left.val;
                if (node.right != null) siblingSum += node.right.val;
                
                if (node.left != null) {
                    node.left.val = totalSum - siblingSum;
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    node.right.val = totalSum - siblingSum;
                    queue.offer(node.right);
                }
            }
        }
        
        return root;
    }
}
