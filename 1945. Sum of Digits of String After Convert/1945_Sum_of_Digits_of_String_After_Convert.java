class Solution {
    public int getLucky(String s, int k) {
        StringBuilder numberStr = new StringBuilder();
        for (char c : s.toCharArray()) {
            int position = c - 'a' + 1;
            numberStr.append(position);
        }

        String currentStr = numberStr.toString();
        int result = 0;
        while (k-- > 0) {
            result = 0;
            for (char c : currentStr.toCharArray()) {
                result += c - '0';
            }
            currentStr = Integer.toString(result);
        }

        return result;
    }
}
