class Solution {
    public int takeCharacters(String s, int k) {
        if (k == 0) return 0;

        Map<Character, Integer> count = new HashMap<>();
        count.put('a', 0);
        count.put('b', 0);
        count.put('c', 0);

        for (char ch : s.toCharArray()) {
            count.put(ch, count.get(ch) + 1);
        }

        if (count.get('a') < k || count.get('b') < k || count.get('c') < k) return -1;

        int requiredA = count.get('a') - k;
        int requiredB = count.get('b') - k;
        int requiredC = count.get('c') - k;

        int left = 0, maxLength = 0;
        Map<Character, Integer> windowCount = new HashMap<>();
        windowCount.put('a', 0);
        windowCount.put('b', 0);
        windowCount.put('c', 0);

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            windowCount.put(ch, windowCount.get(ch) + 1);

            while (windowCount.get('a') > requiredA || windowCount.get('b') > requiredB || windowCount.get('c') > requiredC) {
                char leftChar = s.charAt(left++);
                windowCount.put(leftChar, windowCount.get(leftChar) - 1);
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return s.length() - maxLength;
    }
}
