class Solution {
    public int countCharacters(String[] words, String chars) {
        if (words == null || words.length == 0 || chars == null || chars.length() == 0) {
            return 0;
        }
        
        int[] characters = new int[26];
        for (char c: chars.toCharArray()) {
            characters[c - 'a']++;
        }
        
        int result = 0;
        for (String word: words) {
            result += word.length();
            int[] count = new int[26];
            for (int i = 0; i < word.length(); i++) {
                int charactersNumber = characters[word.charAt(i) - 'a'];
                if (charactersNumber == 0 || count[word.charAt(i) - 'a']++ >= charactersNumber) {
                    result -= word.length();
                    break;
                }
            }
        }
        return result;
    }
}
// Time Cost: O(n * m)
// Space Cost: O(1);