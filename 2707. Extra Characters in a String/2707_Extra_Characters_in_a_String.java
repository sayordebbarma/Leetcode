class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        Set<String> dictSet = new HashSet<>();
        
        for (String word : dictionary) {
            dictSet.add(word);
        }
        
        int[] dp = new int[n + 1];
        
        for (int i = 0; i <= n; i++) {
            dp[i] = n - i;
        }
        
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = dp[i + 1] + 1;
            
            for (String word : dictionary) {
                int len = word.length();
                if (i + len <= n && s.substring(i, i + len).equals(word)) 
                    dp[i] = Math.min(dp[i], dp[i + len]);
            }
        }
        
        return dp[0];
    }
}
