class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        
        for (int num : nums) {
            maxHeap.add(num);
        }
        
        long score = 0;

        for (int i = 0; i < k; i++) {
            int maxElement = maxHeap.poll();
            score += maxElement;
            
            int newElement = (int) Math.ceil(maxElement / 3.0);            
            maxHeap.add(newElement);
        }
        
        return score;
    }
}
