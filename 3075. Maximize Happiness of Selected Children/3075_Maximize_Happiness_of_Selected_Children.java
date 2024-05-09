class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int n = happiness.length;
        long maxHappinessSum = 0;
        int decrementedHappiness = 0;

        Arrays.sort(happiness);

        for (int i = n - 1; i >= n - k; i--) {
            maxHappinessSum += Math.max(0, happiness[i] - decrementedHappiness);
            decrementedHappiness++;
        }

        return maxHappinessSum;   
    }
}
