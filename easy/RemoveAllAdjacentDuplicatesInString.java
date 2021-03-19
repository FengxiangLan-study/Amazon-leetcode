class Solution {
    public String removeDuplicates(String S) {
        // [0, slow] valid characters
        // fast: current visit position
        if (S == null || S.length() == 0) {
            return S;
        }
        
        char[] array = S.toCharArray();
        int slow = 0;
        for (int fast = 1; fast < array.length; fast++) {
          if (slow == -1 || array[fast] != array[slow]) {
            array[++slow] = array[fast];
          }
          else {
            slow--;
          }
        }
        return new String(array, 0, slow + 1);
    }
}
// Time Cost: O(n)
// Space Cost: O(n)