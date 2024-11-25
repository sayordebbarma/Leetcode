class Solution {
    public int slidingPuzzle(int[][] board) {
        StringBuilder start = new StringBuilder();
        for (int[] row : board) for (int cell : row) start.append(cell);
        String target = "123450";
        int[][] moves = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
        
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(start.toString());
        visited.add(start.toString());
        int steps = 0;
        
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                String curr = queue.poll();
                if (curr.equals(target)) return steps;
                int zeroIndex = curr.indexOf('0');
                for (int move : moves[zeroIndex]) {
                    String next = swap(curr, zeroIndex, move);
                    if (visited.add(next)) queue.add(next);
                }
            }
            steps++;
        }
        return -1;
    }
    
    private String swap(String str, int i, int j) {
        char[] chars = str.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }
}
