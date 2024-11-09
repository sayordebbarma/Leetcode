class Solution {
    public long minEnd(int n, int x) {
        final int maxBitLength = calculateBitLength(n) + calculateBitLength(x);
        final long shiftValue = n - 1;
        long result = x;
        int shiftIndex = 0;

        for (int bitPos = 0; bitPos < maxBitLength; ++bitPos) {
            if ((result >> bitPos & 1) == 0) {
                if ((shiftValue >> shiftIndex & 1) == 1)
                    result |= 1L << bitPos;
                
                ++shiftIndex;
            }
        }

        return result;
    }

    private int calculateBitLength(int value) {
        return 32 - Integer.numberOfLeadingZeros(value);
    }
}
