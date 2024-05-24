class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] letterCount = new int[26];
        for (char letter : letters) {
            letterCount[letter - 'a']++;
        }
        return backtrack(words, letterCount, score, 0);
    }

    private static int backtrack(String[] words, int[] letterCount, int[] score, int start) {
        int maxScore = 0;
        
        for (int i = start; i < words.length; i++) {
            int[] tempCount = letterCount.clone();
            int wordScore = 0;
            boolean isValid = true;
            
            for (char c : words[i].toCharArray()) {
                tempCount[c - 'a']--;
                if (tempCount[c - 'a'] < 0) {
                    isValid = false;
                }
                wordScore += score[c - 'a'];
            }
            
            if (isValid) {
                maxScore = Math.max(maxScore, wordScore + backtrack(words, tempCount, score, i + 1));
            }
        }
        
        return maxScore;
    }
}
