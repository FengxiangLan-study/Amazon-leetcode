class MovingAverage {
    private int size;
    private int sum = 0;
    private int count = 0;
    private Queue<Integer> queue = new LinkedList<>();
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
    }
    
    public double next(int val) {
        count++;  
        if (count > size) {
            int remove = queue.poll();
            sum -= remove;
            count--;
        }
        queue.offer(val);
        sum += val;
        return sum * 1.0 / count;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
 // Time Cost: O(1)
 // Space Cost: O(n) n is size