class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Character> mapping = new HashMap<>();
        HashMap<Character, Boolean> mappedChars = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            if (mapping.containsKey(charS)) {
                if (mapping.get(charS) != charT) return false;
            } else {
                if (mappedChars.containsKey(charT)) return false;
                mapping.put(charS, charT);
                mappedChars.put(charT, true);
            }
        }

        return true;
    }
}
