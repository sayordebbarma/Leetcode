class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int[] sortedNums = new int[nums.length];
        List<int[]> mappedList = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int mappedValue = calculateMappedValue(nums[i], mapping);
            mappedList.add(new int[]{mappedValue, i, nums[i]});
        }

        Collections.sort(mappedList, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            } else {
                return Integer.compare(a[1], b[1]);
            }
        });

        for (int i = 0; i < nums.length; i++) {
            sortedNums[i] = mappedList.get(i)[2];
        }

        return sortedNums;
    }

    private int calculateMappedValue(int num, int[] mapping) {
        StringBuilder mappedStringBuilder = new StringBuilder();
        char[] numChars = String.valueOf(num).toCharArray();
        
        for (char ch : numChars) {
            int digit = ch - '0';
            mappedStringBuilder.append(mapping[digit]);
        }

        return Integer.parseInt(mappedStringBuilder.toString());
    }
}
