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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        System.out.println(String.format("1 Processing root - {} - for p - {} - q - {}", root.val,p.val,q.val));
        while (root != null) {
            System.out.println(String.format("Processing root - {} - for p - {} - q - {}", root.val,p.val,q.val));
            if (root.val == p.val) {
                return root;
            }
            if (root.val > p.val) {
                if (root.val > q.val) {
                    root = root.left;
                } else {
                    return root;
                }
            } else if (root.val < p.val) {
                if (root.val < q.val) {
                    root = root.right;
                } else {
                    return root;
                }
            }
            
        }
        return null;
    }
}
