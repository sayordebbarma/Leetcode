class Solution {
    private static class UnionFind {
        private Map<Integer, Integer> parent;
        private Map<Integer, Integer> rank;
        private int count;

        public UnionFind() {
            parent = new HashMap<>();
            rank = new HashMap<>();
            count = 0;
        }

        public int find(int x) {
            if (!parent.containsKey(x)) {
                parent.put(x, x);
                rank.put(x, 0);
                count++;
            }
            if (x != parent.get(x)) {
                parent.put(x, find(parent.get(x)));
            }
            return parent.get(x);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank.get(rootX) > rank.get(rootY)) {
                    parent.put(rootY, rootX);
                } else if (rank.get(rootX) < rank.get(rootY)) {
                    parent.put(rootX, rootY);
                } else {
                    parent.put(rootY, rootX);
                    rank.put(rootX, rank.get(rootX) + 1);
                }
                count--;
            }
        }

        public int getCount() {
            return count;
        }
    }

    public static int removeStones(int[][] stones) {
        UnionFind uf = new UnionFind();

        for (int[] stone : stones) {
            uf.union(stone[0], stone[1] + 10001);
        }

        return stones.length - uf.getCount(); 
    }
}
