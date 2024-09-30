class CustomStack {
    private int[] stack;
    private int size;
    private int maxSize;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
        this.size = 0;
    }

    public void push(int x) {
        if (size < maxSize) {
            stack[size] = x;
            size++;
        }
    }

    public int pop() {
        if (size == 0) return -1;
        
        size--;
        return stack[size];
    }

    public void increment(int k, int val) {
        int limit = Math.min(k, size);
        for (int i = 0; i < limit; i++) {
            stack[i] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
