class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a, b) -> a[0] - b[0]);
        int n = queries.length;
        int[] result = new int[n];
        int[][] queryWithIndex = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            queryWithIndex[i][0] = queries[i];
            queryWithIndex[i][1] = i;
        }
        
        Arrays.sort(queryWithIndex, (a, b) -> a[0] - b[0]);
        
        int maxBeauty = 0, itemIndex = 0;
        
        for (int i = 0; i < n; i++) {
            while (itemIndex < items.length && items[itemIndex][0] <= queryWithIndex[i][0]) {
                maxBeauty = Math.max(maxBeauty, items[itemIndex++][1]);
            }
            result[queryWithIndex[i][1]] = maxBeauty;
        }
        
        return result;
    }
}
