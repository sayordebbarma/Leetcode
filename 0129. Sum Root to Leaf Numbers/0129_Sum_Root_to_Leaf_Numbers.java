class Solution {
  private int totalSum = 0;

  public int sumNumbers(TreeNode root) {
    calculateSum(root, 0);
    return totalSum;
  }

  private void calculateSum(TreeNode node, int currSum) {
    if (node == null) return;

    int sumSoFar = currSum * 10 + node.val;

    if (node.left == null && node.right == null) {
      totalSum += sumSoFar;
      return;
    }

    calculateSum(node.left, sumSoFar);
    calculateSum(node.right, sumSoFar);
  }
}
