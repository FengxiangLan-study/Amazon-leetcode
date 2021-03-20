class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        
        char[] array = s.toCharArray();
        int left = 0;
        int right = 0;
        while (right < array.length) {
            if (array[right] != ' ') {
                right++;
            } else {
                reverse(array, left, right - 1);
                right++;
                left = right;
            }
        }
        reverse(array, left, right - 1);
        return new String(array);
    }
    
    private void reverse(char[] array, int left, int right) {
        while(left < right) {
            char temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }
}
// Time Cost: Since we visit each character twice O(2n) => O(n)
// Space Cost: Since we use char array, O(n)