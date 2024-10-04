class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int n = skill.length;
        int totalSkill = skill[0] + skill[n - 1];
        long chemistrySum = 0;

        int left = 0, right = n - 1;

        while (left < right) {
            int teamSkill = skill[left] + skill[right];

            if (teamSkill != totalSkill) return -1;

            chemistrySum += (long) skill[left] * skill[right];  // Sum of product of skills
            left++;
            right--;
        }

        return chemistrySum;
    }
}
