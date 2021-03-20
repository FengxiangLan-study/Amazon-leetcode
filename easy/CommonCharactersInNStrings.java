class Solution {
    public List<String> commonChars(String[] A) {
        List<String> result = new ArrayList<>();
        if (A == null || A.length == 0) {
            return result;
        }
        
        int[] counts = new int[26];
        for (char c : A[0].toCharArray()) {
            counts[c - 'a']++;
        }
        
        for (int i = 1; i < A.length; i ++) {
            updateCounts(counts, A[i]);
        }
        
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0) {
                for (int j = 0; j < counts[i]; j++) {
                    result.add((char)(i + 'a') + "");
                }
            }
        }
        return result;
    }
    
    private void updateCounts(int[] counts, String string) {
        int[] currentCounts = new int[26];
        for (char c : string.toCharArray()) {
            currentCounts[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            counts[i] = Math.min(counts[i], currentCounts[i]);
        }
    }
}
// Time Cost: O(n * m)
// Space Cost: O(1)