class Solution {
    public int[] sortedSquares(int[] A) {
        if (A == null || A.length == 0) {
            return A;
        }
        
        int left = 0;
        int right = A.length - 1;
        int[] result = new int[A.length];
        for (int i = A.length - 1; i >= 0; i--) {
            if (Math.abs(A[left]) <= Math.abs(A[right])) {
                result[i] = A[right] * A[right];
                right--;
            } else {
                result[i] = A[left] * A[left];
                left++;
            }
        }
        return result;
    }
}
// Time Cost: since we visit each element once O(n)
// Space Cost: O(n)