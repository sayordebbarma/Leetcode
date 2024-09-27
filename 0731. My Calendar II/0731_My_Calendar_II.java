class MyCalendarTwo {
    private Map<Integer, Integer> timeMap = new TreeMap<>();

    public MyCalendarTwo() {
    }

    public boolean book(int start, int end) {
        timeMap.put(start, timeMap.getOrDefault(start, 0) + 1);
        timeMap.put(end, timeMap.getOrDefault(end, 0) - 1);

        int activeEvents = 0;

        for (int count : timeMap.values()) {
            activeEvents += count;

            if (activeEvents > 2) {
                timeMap.put(start, timeMap.get(start) - 1);
                timeMap.put(end, timeMap.get(end) + 1);
                return false;
            }
        }
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
