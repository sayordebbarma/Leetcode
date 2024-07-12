class Solution {
    public int maximumGain(String s, int x, int y) {
        if (x > y) return removeSubstrings(s, "ab", x, "ba", y);
        else return removeSubstrings(s, "ba", y, "ab", x);
    }

    private int removeSubstrings(String s, String first, int firstScore, String second, int secondScore) {
        int totalScore = 0;
        StringBuilder sb = new StringBuilder();
        int length = s.length();

        for (int i = 0; i < length; i++) {
            char currentChar = s.charAt(i);
            sb.append(currentChar);

            int sbLength = sb.length();
            if (sbLength >= 2 && sb.substring(sbLength - 2).equals(first)) {
                sb.delete(sbLength - 2, sbLength);
                totalScore += firstScore;
            }
        }

        String intermediate = sb.toString();
        sb = new StringBuilder();
        length = intermediate.length();

        for (int i = 0; i < length; i++) {
            char currentChar = intermediate.charAt(i);
            sb.append(currentChar);

            int sbLength = sb.length();
            if (sbLength >= 2 && sb.substring(sbLength - 2).equals(second)) {
                sb.delete(sbLength - 2, sbLength);
                totalScore += secondScore;
            }
        }

        return totalScore;
    }
}
