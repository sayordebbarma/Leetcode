class Solution {
    public String customSortString(String order, String s) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        StringBuilder sortedString = new StringBuilder();
        for (char c : order.toCharArray()) {
            if (charCount.containsKey(c)) {
                int count = charCount.get(c);
                for (int i = 0; i < count; i++) {
                    sortedString.append(c);
                }
                charCount.remove(c);
            }
        }

        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            char c = entry.getKey();
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
                sortedString.append(c);
            }
        }

        return sortedString.toString();
    }
}
