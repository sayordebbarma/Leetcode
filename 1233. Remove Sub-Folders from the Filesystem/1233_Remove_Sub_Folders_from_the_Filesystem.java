class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        
        List<String> result = new ArrayList<>();
        
        String prevFolder = folder[0];
        result.add(prevFolder);
        
        for (int i = 1; i < folder.length; i++) {
            if (!folder[i].startsWith(prevFolder + "/")) {
                prevFolder = folder[i];
                result.add(prevFolder);
            }
        }
        
        return result;
    }
}
