class Solution {
    public boolean judgeCircle(String moves) {
        if (moves == null || moves.length() == 0) {
            return true;
        }
        
        int left = 0;
        int up = 0;
        for (char move : moves.toCharArray()) {
            if (move == 'L') {
                left++;
            } else if (move == 'R') {
                left--;
            } else if (move == 'U') {
                up++;
            } else {
                up--;
            }
        }
        return left == 0 && up == 0;
    }
}

// Time Cost: O(n)
// Space Cost: O(1)