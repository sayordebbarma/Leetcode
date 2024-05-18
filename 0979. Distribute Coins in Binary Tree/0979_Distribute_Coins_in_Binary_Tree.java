class Solution {
    int moves = 0;
    
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return moves;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;
        
        int left = dfs(node.left);
        int right = dfs(node.right);
        
        int balance = node.val - 1 + left + right;
        
        moves += Math.abs(balance);
        
        return balance;  
    }
}
