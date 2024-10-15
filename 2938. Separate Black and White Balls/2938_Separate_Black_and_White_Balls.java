class Solution {
    public long minimumSteps(String s) {
        long zeroCount = 0;
        long steps = 0;

        for (final char c : s.toCharArray()) {
            if (c == '1') zeroCount++;
            else steps += zeroCount;
        }

        return steps;
    }
}
