class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostKDistinct(nums, k) - atMostKDistinct(nums, k - 1);
    }

    private int atMostKDistinct(int[] nums, int k) {
        HashMap<Integer, Integer> counter = new HashMap<>();
        int left = 0;
        int distinctCount = 0;
        int totalCount = 0;

        for (int right = 0; right < nums.length; right++) {
            int num = nums[right];
            counter.put(num, counter.getOrDefault(num, 0) + 1);

            if (counter.get(num) == 1) {
                distinctCount++;
            }

            while (distinctCount > k) {
                int leftNum = nums[left];
                counter.put(leftNum, counter.get(leftNum) - 1);
                if (counter.get(leftNum) == 0) {
                    distinctCount--;
                }
                left++;
            }

            totalCount += right - left + 1;
        }

        return totalCount;
    }
}
