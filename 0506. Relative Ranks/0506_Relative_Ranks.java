class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        // Sort the indices array based on the scores
        Arrays.sort(indices, (a, b) -> score[b] - score[a]);

        // Assign ranks based on sorted indices
        String[] ranks = new String[n];
        for (int i = 0; i < n; i++) {
            int originalIndex = indices[i];
            if (i == 0) ranks[originalIndex] = "Gold Medal";
            else if (i == 1) ranks[originalIndex] = "Silver Medal";
            else if (i == 2) ranks[originalIndex] = "Bronze Medal";
            else ranks[originalIndex] = Integer.toString(i + 1);
        }

        return ranks;
    }
}
