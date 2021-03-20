class Solution {
    public int[] frequencySort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer count = map.get(num);
            if (count == null) {
                map.put(num, 1);
            } else {
                map.put(num, count + 1);
            }
        }
        
        PriorityQueue<Integer[]> minHeap = new PriorityQueue<>(new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] one, Integer[] two) {
                if (one[1] == two[1]) {
                    return one[0] > two[0] ? -1 : 1;
                }
                return one[1] < two[1] ? -1 : 1;
            }
        });
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            minHeap.offer(new Integer[] { entry.getKey(), entry.getValue() });
        }
        
        int[] result = new int[nums.length];
        int i = 0;
        while (!minHeap.isEmpty()) {
            Integer[] pair = minHeap.poll();
            for (int j = 0; j < pair[1]; j++) {
                result[i++] = pair[0];
            }
        }
        
        return result;
    }
}
// Time Cost: O(n);
// Space Cost: O(n);