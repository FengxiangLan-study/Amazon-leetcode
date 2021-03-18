class Solution {
    // for each id, we build a minHeap, and size of minHeap will be 5
    // when minHeap over maximum size, we poll top element which is smallest one
    // so we could make sure in the end, minHeap will have top 5 scores.
    public int[][] highFive(int[][] items) {
        if (items == null || items.length == 0) {
            return new int[0][0];
        }
        
        Map<Integer, PriorityQueue<Integer>> idWithMinHeap = new HashMap<>();
        for (int[] item : items) {
            int id = item[0];
            int score = item[1];
            if (idWithMinHeap.containsKey(id)) {
                PriorityQueue<Integer> minHeap = idWithMinHeap.get(id);
                minHeap.offer(score);
                if (minHeap.size() > 5) {
                    minHeap.poll();
                }
            } else {
                PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer one, Integer two) {
                        if (one == two) {
                            return 0;
                        }
                        return one < two ? -1 : 1;
                    }
                });
                minHeap.offer(score);
                idWithMinHeap.put(id, minHeap);
            }
        }
        
        int[][] topFives = new int[idWithMinHeap.size()][2];
        int i = 0;
        for (Integer id: idWithMinHeap.keySet()) {
            Integer sum = 0;
            PriorityQueue<Integer> minHeap = idWithMinHeap.get(id);
            while (!minHeap.isEmpty()) {
                sum += minHeap.poll();
            }
            topFives[i] = new int[] { id, sum / 5};
            i++;
        }
        
        return topFives;
    }
}

// Time Cost: 
// since we visit all elements once, O(n)
// and for each elements we do map search O(logn)
// the size of minHeap is limited, so the push and poll of minHeap is O(1)
// so  total time cost is O(nlogn)
// Space Cost: we use a map and a new array, so O(n) 