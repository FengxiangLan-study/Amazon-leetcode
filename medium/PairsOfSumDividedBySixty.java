class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        // reminders[i] = i means number if x that x % 60 = i
        // if (a + b) % 60 == 0 means
        // a % 60 == 0 and b % 60 == 0
        // OR (a % 60) + (b % 60) == 60
        // so if currentNumber % 60 == 0 it will have reminder[0] pairs
        // if currentNumber % 60 != 0 it will have reminder[60 - currentNumber % 60] pairs
        if (time == null || time.length == 0) {
            return 0;
        }
        int[] reminder = new int[60];
        int count = 0;
        for (int t : time) {
            if (t % 60 == 0) {
                count += reminder[0];
            } else {
                count += reminder[60 - t % 60];
            }
            reminder[t % 60]++;
        }
        return count;
    }
}
// Time Cost: O(n)
// Space Cost: O(n)