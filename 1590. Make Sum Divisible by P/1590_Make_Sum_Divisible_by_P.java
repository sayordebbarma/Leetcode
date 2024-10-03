class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        long totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        int targetModulo = (int)(totalSum % p);
        if (targetModulo == 0) return 0;

        HashMap<Integer, Integer> prefixModMap = new HashMap<>();
        prefixModMap.put(0, -1);
        int currentMod = 0;
        int minLength = n;

        for (int i = 0; i < n; i++) {
            currentMod = (currentMod + nums[i]) % p;

            int targetModToFind = (currentMod - targetModulo + p) % p;

            if (prefixModMap.containsKey(targetModToFind)) {
                minLength = Math.min(minLength, i - prefixModMap.get(targetModToFind));
            }

            prefixModMap.put(currentMod, i);
        }

        return minLength == n ? -1 : minLength;
    }
}
