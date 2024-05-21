class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        backtrack(result, subset, nums, 0);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> subset, int[] nums, int start) {
        result.add(new ArrayList<>(subset));
        
        for (int i = start; i < nums.length; i++) {
            subset.add(nums[i]);
            
            backtrack(result, subset, nums, i + 1);
            
            subset.remove(subset.size() - 1);
        }
    }
}
