class Solution {
    public int lengthOfLastWord(String s) {
        int length = 0;
        boolean wordStarted = false;

        for (int i = s.length() - 1; i >= 0; i--) {
        char c = s.charAt(i);
        if (c != ' ') {
            wordStarted = true;
            length++;
        } else if (wordStarted) {
            break;
        }
        }

        return length;
    }
}
