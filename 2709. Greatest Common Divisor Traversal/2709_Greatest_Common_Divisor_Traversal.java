class UnionFind {
    private int[] id;
    private int[] size;

    public UnionFind(int n) {
        id=new int[n];
        size=new int[n];
        initializeArrays(n);
    }

    private void initializeArrays(int n) {
        for(int i=0; i<n; ++i) {
            id[i]=i;
            size[i]=1;
        }
    }

    public void unionBySize(int u, int v) {
        final int i=find(u);
        final int j=find(v);

        if(i==j) return;
        if(size[i]<size[j]) {
            size[j]+=size[i];
            id[i]=j;
        } else {
            size[i]+=size[j];
            id[j]=i;
        }
    }

    private int find(int u) {
        return id[u]==u ? u : (id[u]=find(id[u]));
    }

    public int getSize(int i) {
        return size[i];
    }
}

class Solution {
    private void buildUF(int[] nums, int[] minPrimeFactors, Map<Integer, Integer> primeToFirstIndex, UnionFind uf) {
        for(int i=0; i<nums.length; ++i) {
            for(final int primeFactor : getPrimeFactors(nums[i], minPrimeFactors)) {
                if(primeToFirstIndex.containsKey(primeFactor)) {
                    uf.unionBySize(primeToFirstIndex.get(primeFactor), i);
                } else {
                    primeToFirstIndex.put(primeFactor, i);
                }
            }
        }
    }

    private boolean checkTraversal(int n, UnionFind uf) {
        for(int i=0; i<n; ++i) {
            if(uf.getSize(i)==n) return true;
        }

        return false;
    }

    private int[] sieveEratosthenes(int n) {
        int[] minPrimeFactors = new int[n+1];
        initializeMinPrimeFactors(minPrimeFactors, n);

        for(int i=2; i*i<n;++i) {
            if(minPrimeFactors[i]==i) markMultiplesAsNonPrime(minPrimeFactors, n, i);
        }

        return minPrimeFactors;
    }

    private void initializeMinPrimeFactors(int[] minPrimeFactors, int n) {
        for(int i=2; i<=n; ++i) {
            minPrimeFactors[i]=i;
        }
    }

    private void markMultiplesAsNonPrime(int[] minPrimeFactors, int n, int i) {
        for(int j=i*i; j<n; j+=i) {
            minPrimeFactors[j]=Math.min(minPrimeFactors[j], i);
        }
    }

    private List<Integer> getPrimeFactors(int num, int[] minPrimeFactors) {
        List<Integer> primeFactors = new ArrayList<>();

        while(num>1) {
            final int divisor = minPrimeFactors[num];
            primeFactors.add(divisor);
            num /= divisor;
        }

        return primeFactors;
    }

    public boolean canTraverseAllPairs(int[] nums) {
        final int n = nums.length;
        final int maxNum = Arrays.stream(nums).max().getAsInt();
        final int[] minPrimeFactors = sieveEratosthenes(maxNum+1);
        Map<Integer, Integer>  primeToFirstIndex = new HashMap<>();
        UnionFind uf = new UnionFind(n); 

        buildUF(nums, minPrimeFactors, primeToFirstIndex, uf);

        return checkTraversal(n, uf);
    }
}
