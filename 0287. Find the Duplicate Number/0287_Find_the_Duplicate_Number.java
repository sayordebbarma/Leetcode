class Solution {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
        if (nums[i] == i + 1) continue;
        else if (nums[nums[i] - 1] != nums[i]) {
            int temp = nums[nums[i] - 1];
            nums[nums[i] - 1] = nums[i];
            nums[i] = temp;
            i--;
        }
    }
    int result = 0;
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] != i + 1) {
            result = nums[i];
            break;
        }
    }
    return result;
    }
}
