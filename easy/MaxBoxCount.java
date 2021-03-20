class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        if (boxTypes == null || boxTypes.length == 0 || boxTypes[0].length == 0 || truckSize == 0) {
            return 0;
        }
        
        Arrays.sort(boxTypes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (b[1] == a[1]) {
                    return 0;
                }
                return b[1] - a[1] < 0 ? -1 : 1;
            }
        });
        
        int maxCount = 0;
        for (int[] box : boxTypes) {
            int boxCount = Math.min(truckSize, box[0]);
            maxCount += boxCount * box[1];
            truckSize -= boxCount;
            if (truckSize == 0) {
                break;
            }
        }
        return maxCount;
    }
}
// Time Cost: O(nlogn)
// Space Cost: O(1)