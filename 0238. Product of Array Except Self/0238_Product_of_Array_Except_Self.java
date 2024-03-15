class Solution {
    public int[] productExceptSelf(int[] nums) {
        final int length = nums.length;
        int[] result = new int[length];
        int[] prefixProduct = new int[length];
        int[] suffixProduct = new int[length];

        prefixProduct[0] = 1;
        for (int i = 1; i < length; ++i) prefixProduct[i] = prefixProduct[i - 1] * nums[i - 1];
        
        suffixProduct[length - 1] = 1;
        for (int i = length - 2; i >= 0; --i) suffixProduct[i] = suffixProduct[i + 1] * nums[i + 1];
        for (int i = 0; i < length; ++i) result[i] = prefixProduct[i] * suffixProduct[i];

        return result;
    }
}
