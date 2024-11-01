class Solution {
    public String makeFancyString(String s) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            int n = result.length();
            
            if (n >= 2 && result.charAt(n - 1) == s.charAt(i) && result.charAt(n - 2) == s.charAt(i)) {
                continue;
            }
            
            result.append(s.charAt(i));
        }
        
        return result.toString();
    }
}
