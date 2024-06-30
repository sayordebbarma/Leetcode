class Solution {
        class UnionFind {
        private int[] parent;
        private int[] rank;

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
                return true;
            }
            return false;
        }

        public boolean isConnected() {
            int root = find(1);
            for (int i = 2; i < parent.length; i++) {
                if (find(i) != root) return false;
            }
            return true;
        }
    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind ufBoth = new UnionFind(n + 1);
        UnionFind ufAlice = new UnionFind(n + 1);
        UnionFind ufBob = new UnionFind(n + 1);

        int edgesUsed = 0;

        for (int[] edge : edges) {
            if (edge[0] == 3) {
                if (ufBoth.union(edge[1], edge[2])) {
                    ufAlice.union(edge[1], edge[2]);
                    ufBob.union(edge[1], edge[2]);
                    edgesUsed++;
                }
            }
        }

        for (int[] edge : edges) {
            if (edge[0] == 1) {
                if (ufAlice.union(edge[1], edge[2])) edgesUsed++;
            }
        }

        for (int[] edge : edges) {
            if (edge[0] == 2) {
                if (ufBob.union(edge[1], edge[2])) edgesUsed++;
            }
        }

        if (ufAlice.isConnected() && ufBob.isConnected()) return edges.length - edgesUsed;
        else return -1;
    }
}
