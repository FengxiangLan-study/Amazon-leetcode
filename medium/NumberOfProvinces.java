class Solution {
    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0 || isConnected[0].length == 0) {
            
            return 0;
        }
        Queue<Integer> queue = new LinkedList<>();
        int num = 0;
        int n = isConnected.length;
        for (int i = 0; i < n; i++) {
            if (isConnected[i][i] == 1) {
                num++;
                isConnected[i][i] = 0;
                queue.offer(i);
                while(!queue.isEmpty()) {
                    int cur = queue.poll();
                    isConnected[cur][cur] = 0;
                    for (int j = i + 1; j < n; j++) {
                        if (isConnected[cur][j] == 1 && isConnected[j][j] == 1) {
                            queue.offer(j);
                        }
                    }
                }
            }
        }
        return num;
    }
}
// Time Cost: O(n^2)
// Space Cost: O(n)