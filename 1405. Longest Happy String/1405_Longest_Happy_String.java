class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((x, y) -> y[1] - x[1]);
        
        if (a > 0) maxHeap.offer(new int[] { 'a', a });
        if (b > 0) maxHeap.offer(new int[] { 'b', b });
        if (c > 0) maxHeap.offer(new int[] { 'c', c });
        
        StringBuilder result = new StringBuilder();
        
        while (!maxHeap.isEmpty()) {
            int[] first = maxHeap.poll();
            
            if (result.length() >= 2 && result.charAt(result.length() - 1) == first[0] && result.charAt(result.length() - 2) == first[0]) {
                if (maxHeap.isEmpty()) break;
                
                int[] second = maxHeap.poll();
                result.append((char) second[0]);
                second[1]--;
                
                if (second[1] > 0) maxHeap.offer(second);
                
                maxHeap.offer(first);
            } else {
                result.append((char) first[0]);
                first[1]--;
                
                if (first[1] > 0) maxHeap.offer(first);
            }
        }
        
        return result.toString();
    }
}
