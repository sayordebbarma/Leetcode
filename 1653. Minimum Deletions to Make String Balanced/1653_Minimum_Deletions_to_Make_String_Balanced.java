class Solution {
    public int minimumDeletions(String s) {
        int count_b = 0;
        int dp = 0;

        for (final char c : s.toCharArray()) {
            if (c == 'a') dp = Math.min(dp + 1, count_b);
            else ++count_b;
        }

        return dp;
    }
}
