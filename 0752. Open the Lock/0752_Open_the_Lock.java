class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        int level = 0;

        if (deadSet.contains("0000")) {
            return -1;
        }

        queue.offer("0000");
        visited.add("0000");

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (current.equals(target)) {
                    return level;
                }
                List<String> nextStates = getNextStates(current);
                for (String nextState : nextStates) {
                    if (!deadSet.contains(nextState) && !visited.contains(nextState)) {
                        queue.offer(nextState);
                        visited.add(nextState);
                    }
                }
            }
            level++;
        }

        return -1;
    }

    private List<String> getNextStates(String current) {
        List<String> nextStates = new ArrayList<>();
        char[] chars = current.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char originalChar = chars[i];
            chars[i] = (char) ((chars[i] - '0' + 1) % 10 + '0');
            nextStates.add(new String(chars));
            chars[i] = (char) ((originalChar - '0' + 9) % 10 + '0');
            nextStates.add(new String(chars));
            chars[i] = originalChar;
        }
        return nextStates;
    }
}
