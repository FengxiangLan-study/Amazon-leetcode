/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sumRootToLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int[] result = { 0 };
        preOrder(root, 0, result);
        return result[0];
    }
    
    private void preOrder(TreeNode node, int curNumber, int[] result) {
        if (node == null) {
            return;
        }
        
        curNumber = (curNumber << 1) | node.val;
        if (node.left == null && node.right == null) {
            result[0] += curNumber;
        }
        preOrder(node.left, curNumber, result);
        preOrder(node.right, curNumber, result);
    }
}
// Time Cost: since we visited each node once, O(n)
// Space Cost: O(h) h is height of tree