class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int leftPointer = 0;
        int rightPointer = ans.length-1;

        for(int i=ans.length-1; i>=0; i--) {
            int leftSq = nums[leftPointer]*nums[leftPointer];
            int rightSq = nums[rightPointer]*nums[rightPointer];

            if(leftSq<rightSq) {
                ans[i] = rightSq;
                rightPointer--;
            } else {
                ans[i] = leftSq;
                leftPointer++;
            }
        }

        return ans;
    }
}
