class Solution {
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder(s);
        int i = 0;
        while (i < sb.length() - 1) {
            char curr = sb.charAt(i);
            char next = sb.charAt(i + 1);
            if (Character.toLowerCase(curr) == Character.toLowerCase(next) && curr != next) {
                sb.delete(i, i + 2);
                i = Math.max(0, i - 1);
            } else {
                i++;
            }
        }
        return sb.toString();
    }
}
