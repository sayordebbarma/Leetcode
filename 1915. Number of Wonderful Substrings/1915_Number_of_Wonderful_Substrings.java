class Solution {
    public long wonderfulSubstrings(String word) {
        int[] count = new int[1024];
        count[0] = 1;
        int bitmask = 0;
        long result = 0;

        for (final char ch : word.toCharArray()) {
            int index = 1 << (ch - 'a');
            bitmask ^= index;
            result += count[bitmask];
            for (int i = 0; i < 10; i++) {
                result += count[bitmask ^ (1 << i)];
            }
            count[bitmask]++;
        }

        return result;
    }
}
