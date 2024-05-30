class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int[] prefixXOR = new int[n + 1];
        
        for (int i = 0; i < n; i++) {
            prefixXOR[i + 1] = prefixXOR[i] ^ arr[i];
        }
        
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            for (int k = i + 1; k < n; k++) {
                if (prefixXOR[i] == prefixXOR[k + 1]) count += (k - i);
            }
        }
        
        return count;
    }
}
