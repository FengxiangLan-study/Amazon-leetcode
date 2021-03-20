class Solution {
    public double average(int[] salary) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        double sum = 0;
        for (int s : salary) {
            max = Math.max(max, s);
            min = Math.min(min, s);
            sum += s;
        }
        sum = sum - max - min;
        return sum / (salary.length - 2);
    }
}
// Time Cost: O(n)
// Space Cost: O(1)