class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> prefixSet = new HashSet<>();
        
        for (int num : arr1) {
            int currentPrefix = num;
            while (currentPrefix > 0) {
                prefixSet.add(currentPrefix);
                currentPrefix /= 10;
            }
        }

        int maxLength = 0;
        
        for (int num : arr2) {
            int currentPrefix = num;
            while (currentPrefix > 0) {
                if (prefixSet.contains(currentPrefix)) {
                    maxLength = Math.max(maxLength, Integer.toString(currentPrefix).length());
                    break;
                }
                currentPrefix /= 10;
            }
        }
        
        return maxLength;
    }
}
