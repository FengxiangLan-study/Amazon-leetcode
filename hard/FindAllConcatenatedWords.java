class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        if (words == null || words.length == 0) {
            return result;
        }
        Set<String> dictSet = new HashSet<>();
        Arrays.sort(words, new Comparator<String>() {
            public int compare (String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
        for (String word : words) {
            if (canBreak(word, dictSet)) {
                result.add(word);
            }
            dictSet.add(word);
        }
        return result;
    }
    
    private boolean canBreak(String word, Set<String> set) {
        if (word.length() == 0 || set.isEmpty()) {
            return false;
        }
        boolean[] canBreak = new boolean[word.length() + 1];
        // canBreak[i] represents the substring from (0, i - 1) can breaked
        // canBreak[i] = canBreak[j] && input(j, i) in set, j is from 0 to i - 1
        canBreak[0] = true;
        for (int i = 1; i < canBreak.length; i++) {
            for (int j = 0; j < i; j++) {
                if (set.contains(word.substring(j, i)) && canBreak[j]) {
                    canBreak[i] = true;
                    break;
                }
            }
        }
        return canBreak[canBreak.length - 1];
    }
}

// Time Cost: O(n * k ^ 3) k is average length of each word
// Space Cost: O(k)