class Solution {
    public int findTheWinner(int n, int k) {
        return josephus(n, k) + 1;
    }

    private static int josephus(int n, int k) {
        int winner = 0;
        for (int i = 1; i <= n; i++) {
            winner = (winner + k) % i;
        }
        return winner;
    }
}
