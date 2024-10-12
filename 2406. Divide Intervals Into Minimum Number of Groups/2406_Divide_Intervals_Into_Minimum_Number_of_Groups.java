class Solution {
    public int minGroups(int[][] intervals) {
        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];
        
        for (int i = 0; i < n; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        
        Arrays.sort(start);
        Arrays.sort(end);
        
        int groups = 0, active = 0;
        int i = 0, j = 0;
        
        while (i < n) {
            if (start[i] <= end[j]) {
                active++;
                groups = Math.max(groups, active);
                i++;
            } else {
                active--;
                j++;
            }
        }
        
        return groups;
    }
}
