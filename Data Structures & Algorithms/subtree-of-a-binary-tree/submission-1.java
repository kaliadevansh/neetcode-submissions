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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        boolean isSameAsRoot = isSameTree(root, subRoot);
        if (!isSameAsRoot) {
            boolean isLeftSubTree = false;
            boolean isRightSubTree = false;
            if (root.left != null) {
                isLeftSubTree = isSubtree(root.left, subRoot);
            }
            if (root.right != null) {
                isRightSubTree = isSubtree(root.right, subRoot);
            }
            return isLeftSubTree || isRightSubTree;
        }
        return isSameAsRoot;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        } else if (p.val != q.val) {
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}
