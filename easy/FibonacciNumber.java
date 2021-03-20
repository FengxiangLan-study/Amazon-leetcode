class Solution {
    public int fib(int n) {
        // fib[i] = fib[i - 1] + fib[i - 2];
        if (n <= 1) {
            return n;
        }
        
        int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n];
    }
}
// Time Cost: O(n);
// Space Cost: O(n);