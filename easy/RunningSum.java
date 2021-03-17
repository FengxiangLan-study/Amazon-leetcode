class Solution {
    public int[] runningSum(int[] nums) {
        // sum[i] = sum[i - 1] + nums[i]
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}

// Time Cost: O(n)
// Space Cost: O(1)