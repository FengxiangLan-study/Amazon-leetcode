class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int start = 0;
        int maxH = 0;
        int maxV = 0;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        for (int i = 0; i < horizontalCuts.length; i++) {
            maxH = Math.max(maxH, horizontalCuts[i] - start);
            start = horizontalCuts[i];            
        }
        maxH = Math.max(maxH, h - start);
        
        start = 0;
        for (int i = 0; i < verticalCuts.length; i++) {
            maxV = Math.max(maxV, verticalCuts[i] - start);
            start = verticalCuts[i];            
        }
        maxV = Math.max(maxV, w - start);
        long res = (long)maxH * (long)maxV;
        res %= (int)1E9 + 7;
        return (int)res;   
    }
}
// Time Cost: O(m) m = max(h, w)
// Space Cost: O(1)