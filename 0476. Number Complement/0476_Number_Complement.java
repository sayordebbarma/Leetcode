class Solution {
    public int findComplement(int num) {
        int numberOfBits = (int)(Math.log(num) / Math.log(2)) + 1;
        int mask = (1 << numberOfBits) - 1;
        return num ^ mask;
    }
}
