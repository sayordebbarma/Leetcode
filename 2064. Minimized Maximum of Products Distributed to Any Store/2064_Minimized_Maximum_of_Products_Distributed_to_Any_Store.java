class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int left = 1, right = 0;
        for (int q : quantities) right = Math.max(right, q);
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canDistribute(mid, n, quantities)) right = mid;
            else left = mid + 1;
        }
        
        return left;
    }
    
    private boolean canDistribute(int maxProductsPerStore, int n, int[] quantities) {
        int requiredStores = 0;
        for (int q : quantities) {
            requiredStores += (q + maxProductsPerStore - 1) / maxProductsPerStore;
            if (requiredStores > n) return false;
        }
        return true;
    }
}
