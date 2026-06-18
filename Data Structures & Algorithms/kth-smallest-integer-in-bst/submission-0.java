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
    int count = 0;
    int result = 0;
    public int kthSmallest(TreeNode root, int k) {
        /*
        Algorithm - 
            Traverse till the smallest node.
            have a counter, increment the counter starting with smallest (left most) node.
            do in order traversal. 
        */
        inOrderTraversal(root, k);
        return result;
    }

    void inOrderTraversal(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        if (count >=k) {
            return;
        }
        
        inOrderTraversal(root.left, k);
        
        count++;
        if (count == k) {
            result=root.val;
            return;
        }
        
            inOrderTraversal(root.right,k);
        
    }
}
