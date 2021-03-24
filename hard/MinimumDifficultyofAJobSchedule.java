class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        // dp[i][j] = min diff to schedule first i job in j days
        // dp[0][0] = 0; dp[][]
        // dp[i][j] = min(d[k][j - 1] + max(jobDifficulty[r])) r from j + 1 to i and k from j - 1 to i - 1
        if (jobDifficulty == null || jobDifficulty.length < d) {
            return -1;
        }
        
        int n = jobDifficulty.length;
        int[][] dp = new int[n + 1][d + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= d; j++) {
                dp[i][j] = Integer.MAX_VALUE / 2;
            }
        }
        dp[0][0] = 0;

        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= d; j++) {
                int maxDiff = 0;
                for (int k = i - 1; k >= j - 1; k--) {
                    maxDiff = Math.max(maxDiff, jobDifficulty[k]);
                    dp[i][j] = Math.min(dp[i][j], dp[k][j - 1] + maxDiff);
                    
                }
            }
        }
        return dp[n][d];
    }
}
// Time Cost: O(n^2 * d)
// Space Cost: o(n * d)