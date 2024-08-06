class Solution {
    public int minimumPushes(String word) {
        int totalPushes = 0;
        int[] letterCount = new int[26];

        for (char c : word.toCharArray()) {
            letterCount[c - 'a']++;
        }

        Arrays.sort(letterCount);

        for (int i = 0; i < 26; ++i) {
            totalPushes += letterCount[25 - i] * (i / 8 + 1);
        }

        return totalPushes;
    }
}
