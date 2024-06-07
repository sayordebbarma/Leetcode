class Solution {
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        String word = null;
    }
    
    static class Trie {
        TrieNode root = new TrieNode();
        
        public void insert(String word) {
            TrieNode current = root;
            for (char c : word.toCharArray()) {
                current.children.putIfAbsent(c, new TrieNode());
                current = current.children.get(c);
            }
            current.word = word;
        }
        
        public String findRoot(String word) {
            TrieNode current = root;
            for (char c : word.toCharArray()) {
                if (current.word != null) return current.word;
                if (!current.children.containsKey(c)) return word;
                current = current.children.get(c);
            }
            return current.word != null ? current.word : word;
        }
    }
    
    public static String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String root : dictionary) {
            trie.insert(root);
        }
        
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = trie.findRoot(words[i]);
        }
        
        return String.join(" ", words);  
    }
}
