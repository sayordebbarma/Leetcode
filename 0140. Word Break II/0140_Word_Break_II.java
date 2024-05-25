class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dictionary = new HashSet<>(wordDict);
        Map<String, List<String>> memo = new HashMap<>();
        return backtrack(s, dictionary, memo);
    }

    private List<String> backtrack(String s, Set<String> dictionary, Map<String, List<String>> memo) {
        if (memo.containsKey(s)) return memo.get(s);

        List<String> result = new ArrayList<>();

        for (int end = 1; end < s.length(); end++) {
            String prefix = s.substring(0, end);
            String remainder = s.substring(end);
            if (dictionary.contains(prefix)) {
                List<String> suffixWays = backtrack(remainder, dictionary, memo);
                for (String suffix : suffixWays) {
                    result.add(prefix + " " + suffix);
                }
            }
        }

        if (dictionary.contains(s)) result.add(s);

        memo.put(s, result);
        return result;
    }
}
