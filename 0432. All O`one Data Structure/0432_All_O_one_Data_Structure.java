class AllOne {
    private final Node root = new Node();
    private final Map<String, Node> nodes = new HashMap<>();

    public AllOne() {
        root.next = root.prev = root;
    }

    public void inc(String key) {
        if (!nodes.containsKey(key)) {
            if (root.next == root || root.next.cnt > 1) {
                nodes.put(key, root.insert(new Node(key, 1)));
            } else {
                root.next.keys.add(key);
                nodes.put(key, root.next);
            }
        } else {
            Node cur = nodes.get(key), next = cur.next;
            if (next == root || next.cnt > cur.cnt + 1) {
                nodes.put(key, cur.insert(new Node(key, cur.cnt + 1)));
            } else {
                next.keys.add(key);
                nodes.put(key, next);
            }
            cur.keys.remove(key);
            if (cur.keys.isEmpty()) cur.remove();
        }
    }

    public void dec(String key) {
        Node cur = nodes.get(key);
        if (cur.cnt == 1) {
            nodes.remove(key);
        } else {
            Node prev = cur.prev;
            if (prev == root || prev.cnt < cur.cnt - 1) {
                nodes.put(key, prev.insert(new Node(key, cur.cnt - 1)));
            } else {
                prev.keys.add(key);
                nodes.put(key, prev);
            }
        }
        cur.keys.remove(key);
        if (cur.keys.isEmpty()) cur.remove();
    }

    public String getMaxKey() {
        return root.prev == root ? "" : root.prev.keys.iterator().next();
    }

    public String getMinKey() {
        return root.next == root ? "" : root.next.keys.iterator().next();
    }
}

class Node {
    Node prev, next;
    int cnt;
    Set<String> keys = new HashSet<>();

    Node() {
        this("", 0);
    }

    Node(String key, int cnt) {
        this.cnt = cnt;
        keys.add(key);
    }

    Node insert(Node node) {
        node.prev = this;
        node.next = this.next;
        this.next.prev = node;
        this.next = node;
        return node;
    }

    void remove() {
        prev.next = next;
        next.prev = prev;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
