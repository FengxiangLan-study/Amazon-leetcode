class Solution {
    // slow = 0 fast = 0; fast means current position
    // 0 - slow - 1 is valid result. so slow is next valid character
    // if s[fast] != vowels, s[slow++] = s[fast++] else fast++
    public String removeVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        
        char[] array = s.toCharArray();
        int slow = 0;
        int fast = 0;
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        while (fast < array.length) {
            if (vowels.contains(array[fast])) {
                fast++;
            } else {
                array[slow++] = array[fast++];
            }
        }
        return new String(array, 0, slow);
    }
}

// Time Cost: since we visit all characters one time, so O(n) and n is length of s
// Space Cost: we generate an array from s, so O(n) and n is length of s