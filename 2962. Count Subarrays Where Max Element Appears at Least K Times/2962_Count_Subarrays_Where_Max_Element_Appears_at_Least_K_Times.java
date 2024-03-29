class Solution {
    public long countSubarrays(int[] nums, int k) {
        final int maxNum = Arrays.stream(nums).max().getAsInt();
        long ans = 0;
        int count = 0;

        for (int left = 0, right = 0; right < nums.length; ++right) {
            if (nums[right] == maxNum)
                ++count;
            while (count == k)
                if (nums[left++] == maxNum)
                    --count;
            ans += left;
        }

        return ans;
    }
}
