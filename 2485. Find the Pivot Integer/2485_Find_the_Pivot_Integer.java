class Solution {
    public int pivotInteger(int n) {
        long totalSum = n * (n + 1L) / 2L;
        
        long leftSum = 0;
        for (int i = 1; i <= n; i++) {
            leftSum += i;
            long rightSum = totalSum - leftSum + i;
            if (leftSum == rightSum)
                return i;
        }
        
        return -1;
    }
}
