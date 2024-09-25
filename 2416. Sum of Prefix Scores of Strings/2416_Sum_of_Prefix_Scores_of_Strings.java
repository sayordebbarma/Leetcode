class TrieNode {
    Map<Character, TrieNode> children;
    int count;

    public TrieNode() {
        children = new HashMap<>();
        count = 0;
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            node.children.putIfAbsent(ch, new TrieNode());
            node = node.children.get(ch);
            node.count++;
        }
    }

    public int getPrefixScores(String word) {
        TrieNode node = root;
        int score = 0;
        for (char ch : word.toCharArray()) {
            if (node.children.containsKey(ch)) {
                node = node.children.get(ch);
                score += node.count;
            } else {
                break;
            }
        }
        return score;
    }
}

class Solution {
    public int[] sumPrefixScores(String[] words) {
        Trie trie = new Trie();
        
        for (String word : words) {
            trie.insert(word);
        }
        
        int[] result = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            result[i] = trie.getPrefixScores(words[i]);
        }
        
        return result;
    }
}
