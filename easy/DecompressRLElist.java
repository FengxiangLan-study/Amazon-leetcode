class Solution {
    public int[] decompressRLElist(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        
        List<Integer> result = new ArrayList<>();
        int index = 0;
        while (index < nums.length - 1) {
            int freq = nums[index];
            while (freq > 0) {
                result.add(nums[index + 1]);
                freq--;
            }
            index += 2;
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
}

// Time Cost: O(n * m);
// Space Cost: O(n * m);