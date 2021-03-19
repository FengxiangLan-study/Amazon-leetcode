class Logger {
    private Map<String, Integer> record;
    /** Initialize your data structure here. */
    public Logger() {
        this.record = new HashMap<String, Integer>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        Integer validTimestamp = record.get(message);
        if (validTimestamp == null || timestamp >= validTimestamp) {
            record.put(message, timestamp + 10);
            return true;
        }
        return false;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
 // Time Cost: O(1)
 // Space Cost: O(n)