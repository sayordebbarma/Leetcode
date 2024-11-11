class Solution {
    public boolean primeSubOperation(int[] nums) {
        final int LIMIT = 1000;
        List<Integer> primeList = generatePrimes(LIMIT);

        int lastValue = 0;
        for (int value : nums) {
            int idx = findFirstLargerOrEqual(primeList, value - lastValue);
            if (idx > 0) value -= primeList.get(idx - 1);
            
            if (value <= lastValue) return false;
            
            lastValue = value;
        }

        return true;
    }

    private List<Integer> generatePrimes(int max) {
        List<Integer> primes = new ArrayList<>();
        boolean[] sieve = new boolean[max];
        Arrays.fill(sieve, true);
        sieve[0] = sieve[1] = false;
        
        for (int i = 2; i * i < max; ++i) {
            if (sieve[i]) {
                for (int j = i * i; j < max; j += i) {
                    sieve[j] = false;
                }
            }
        }
        
        for (int i = 2; i < max; ++i) {
            if (sieve[i]) primes.add(i);
        }
        return primes;
    }

    private int findFirstLargerOrEqual(List<Integer> primes, int threshold) {
        int index = Collections.binarySearch(primes, threshold);
        return index < 0 ? -index - 1 : index;
    }
}
