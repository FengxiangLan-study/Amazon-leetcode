class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        
        int[] temp = nums.clone();
        Arrays.sort(temp);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < temp.length; i++) {
            Integer count = map.get(temp[i]);
            if (count == null) {
                map.put(temp[i], i);
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            nums[i] = map.get(nums[i]);
        }
        return nums;
    }
}

// Time Cost: O(n)
// Space Cost: O(n)