class Solution {
    public int[] replaceElements(int[] arr) {
        // temp = arr[i]
        // arr[i] = max;
        // max = max(max, temp)
        // arr[len - 1] = -1;
        if (arr == null || arr.length == 0) {
            return new int[0];
        }
        
        int max = arr[arr.length - 1];
        arr[arr.length - 1] = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = max;
            max = Math.max(max, temp);
        }
        return arr;
    }
}
// Time Cost: O(n)
// Space Cost: O(1);