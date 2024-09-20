class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;

        String rev_s = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + rev_s;
        int[] prefixTable = computeKMPTable(combined);
        int longestPrefixLength = prefixTable[combined.length() - 1];
        
        return rev_s.substring(0, s.length() - longestPrefixLength) + s;
    }

    private int[] computeKMPTable(String s) {
        int n = s.length();
        int[] table = new int[n];
        int j = 0;
        
        for (int i = 1; i < n; i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = table[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) j++;
            
            table[i] = j;
        }
        return table;
    }
}
