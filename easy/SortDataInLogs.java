class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, new Comparator<String>() {
            @Override
            public int compare(String log1, String log2) {
                String[] splitLog1 = log1.split(" ", 2);
                String[] splitLog2 = log2.split(" ", 2);
                boolean isDigit1 = Character.isDigit(splitLog1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(splitLog2[1].charAt(0));
                if (!isDigit1 && !isDigit2) {
                    int order = splitLog1[1].compareTo(splitLog2[1]);
                    if (order != 0) {
                        return order;
                    }
                    return splitLog1[0].compareTo(splitLog2[0]);
                }
                return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
            }
        });
        return logs;
    }
}
// Time Cost: O(m * n * logn) n be the number of logs in the list and m be the maximum length of a single log.
/*
1. First of all, the time complexity of the Arrays.sort() is O(nlogn), as stated in the API specification, which is to say that the compare() function would be invoked O(nlogn) times.
2. For each invocation of the compare() function, it could take up to O(m) time, since we compare the contents of the logs.
3. Therefore, the overall time complexity of the algorithm is O(m * n * logn).
*/

// Space Cost: O(m * logn)
/*
For each invocation of the compare() function, we would need up to O(m) space to hold the parsed logs.
In addition, since the implementation of Arrays.sort() is based on quicksort algorithm whose space complexity is O(logn), assuming that the space for each element is O(1). Since each log could be of O(m) space, we would need O(m * logn) space to hold the intermediate values for sorting.
In total, the overall space complexity of the algorithm is O(m + m * logn) = O(m * logn).
*/