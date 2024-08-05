class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> countMap = new HashMap<>();
        for (String str : arr) {
            countMap.put(str, countMap.getOrDefault(str, 0) + 1);
        }

        List<String> distinctStrings = new ArrayList<>();
        for (String str : arr) {
            if (countMap.get(str) == 1) distinctStrings.add(str);
        }

        if (k <= distinctStrings.size()) return distinctStrings.get(k - 1);
        else return "";
    }
}
