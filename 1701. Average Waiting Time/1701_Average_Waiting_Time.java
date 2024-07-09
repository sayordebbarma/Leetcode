class Solution {
    public double averageWaitingTime(int[][] customers) {
        int n = customers.length;
        double totalWaitingTime = 0;
        double currentTime = 0;

        for (int[] customer : customers) {
            currentTime = Math.max(currentTime, 1.0 * customer[0]) + customer[1];
            totalWaitingTime += currentTime - customer[0];
        }

        return 1.0 * totalWaitingTime / n;
    }
}
