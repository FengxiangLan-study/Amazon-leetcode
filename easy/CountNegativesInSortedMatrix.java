class Solution {
    public int countNegatives(int[][] grid) {
        // for each row do binary search
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            count += countNegatives(grid[i]);
        }
        return count;
    }
    
    private int countNegatives(int[] row) {
        int left = 0;
        int right = row.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (row[mid] >= 0) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return row[right] < 0 ? row.length - right : 0;
    }
}

// Time Cost: since we visit each row once, and for each row, we do binary search, so O(m * logn)
// Space Cost: O(1)