class Solution {
    public int longestIdealString(String s, int k) {
    int[] dp = new int[26];

    for (char c : s.toCharArray()) {
      int index = c - 'a';
      dp[index] = 1 + getMaxReachable(dp, index, k);
    }

    return Arrays.stream(dp).max().getAsInt();
  }

  private int getMaxReachable(int[] dp, int index, int k) {
    int start = Math.max(0, index - k);
    int end = Math.min(25, index + k);
    int maxReachable = 0;

    for (int j = start; j <= end; j++) {
      maxReachable = Math.max(maxReachable, dp[j]);
    }

    return maxReachable;
    }
}
