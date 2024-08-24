class Solution {
    public String nearestPalindromic(String n) {
        long originalNumber = Long.parseLong(n);
        long closestPalindrome = -1;

        for (long candidate : generatePalindromes(n)) {
            if (closestPalindrome == -1 || 
                Math.abs(candidate - originalNumber) < Math.abs(closestPalindrome - originalNumber) ||
                (Math.abs(candidate - originalNumber) == Math.abs(closestPalindrome - originalNumber) && candidate < closestPalindrome)) {
                closestPalindrome = candidate;
            }
        }

        return String.valueOf(closestPalindrome);
    }

    private Set<Long> generatePalindromes(String n) {
        int length = n.length();
        Set<Long> palindromes = new HashSet<>();

        palindromes.add((long) Math.pow(10, length - 1) - 1);
        palindromes.add((long) Math.pow(10, length) + 1);

        long prefix = Long.parseLong(n.substring(0, (length + 1) / 2));
        
        for (long i = prefix - 1; i <= prefix + 1; i++) {
            StringBuilder palindrome = new StringBuilder();
            palindrome.append(i);
            palindrome.append(new StringBuilder(Long.toString(i)).reverse().substring(length % 2));
            palindromes.add(Long.parseLong(palindrome.toString()));
        }

        palindromes.remove(Long.parseLong(n));
        return palindromes;
    }
}
