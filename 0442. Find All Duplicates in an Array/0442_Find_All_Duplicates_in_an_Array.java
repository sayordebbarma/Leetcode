class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();

        for (int n : nums) {
            int absN = Math.abs(n);
            if (!seen.add(absN)) {
                result.add(absN);
            }
        }

        return result;
    }
}
