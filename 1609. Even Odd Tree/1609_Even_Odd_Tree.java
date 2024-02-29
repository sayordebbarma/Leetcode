class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        if(root==null) return true;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        boolean evenLevel = true;
        while(q.size()>0) {
            int s = q.size();
            int prev = evenLevel ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            while(s-- >0) {
                root = q.poll();
                if(evenLevel && (root.val%2==0 || root.val<=prev)) return false;
                if(!evenLevel && (root.val%2==1 || root.val>=prev)) return false;
                prev = root.val;

                if(root.left!=null) q.add(root.left);
                if(root.right!=null) q.add(root.right);
            }
            evenLevel=!evenLevel;
        }

        return true;
    }
}
