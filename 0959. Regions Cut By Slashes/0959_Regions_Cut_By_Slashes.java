class Solution {
    private int find(int[] parent, int x) {
        if (parent[x] != x) parent[x] = find(parent, parent[x]);
        
        return parent[x];
    }
    
    private void union(int[] parent, int[] rank, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int size = n * n * 4;
        int[] parent = new int[size];
        int[] rank = new int[size];
        
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int index = 4 * (i * n + j);
                char c = grid[i].charAt(j);
                
                if (c == ' ') {
                    union(parent, rank, index, index + 1);
                    union(parent, rank, index + 1, index + 2);
                    union(parent, rank, index + 2, index + 3);
                } else if (c == '/') {
                    union(parent, rank, index, index + 3);
                    union(parent, rank, index + 1, index + 2);
                } else if (c == '\\') {
                    union(parent, rank, index, index + 1);
                    union(parent, rank, index + 2, index + 3);
                }
                
                if (j + 1 < n) union(parent, rank, index + 1, index + 4 + 3);
                
                if (i + 1 < n) union(parent, rank, index + 2, index + 4 * n);
            }
        }
        
        int regions = 0;
        for (int i = 0; i < size; i++) {
            if (find(parent, i) == i) regions++;
        }
        
        return regions;
    }
}
