class Solution {
    public int calPoints(String[] ops) {
        if (ops == null || ops.length == 0) {
            return 0;
        }
        
        Deque<Integer> stack = new LinkedList<>();
        for (String s : ops) {
            if (s.charAt(0) == 'C') {
                stack.pollFirst();
            } else if ( s.charAt(0) == 'D') {
                int last = stack.peekFirst();
                stack.offerFirst(last * 2);
            } else if (s.charAt(0) == '+') {
                int last = stack.pollFirst();
                int secondLast = stack.peekFirst();
                stack.offerFirst(last);
                stack.offerFirst(last + secondLast);
            } else {
                stack.offerFirst(Integer.parseInt(s));
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pollFirst();
        }
        return result;
    }
}
// Time Cost: since we visit each string once, O(n)
// Space Cost: O(n)