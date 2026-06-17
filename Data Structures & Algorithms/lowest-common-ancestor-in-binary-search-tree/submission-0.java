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
        boolean doesRootContainP = false;
        boolean doesRootContainQ = false;
        boolean doesLeftContainP = false;
        boolean doesLeftContainQ = false;
        boolean doesRightContainP = false;
        boolean doesRightContainQ = false;

        doesRootContainP = doesTreeContainNode(root, p);
        doesRootContainQ = doesTreeContainNode(root, q);

        if (root.left != null) {
            doesLeftContainP = doesTreeContainNode(root.left, p);
            doesLeftContainQ = doesTreeContainNode(root.left, q);
        }
        
        if (root.right != null) {
            doesRightContainP = doesTreeContainNode(root.right, p);
            doesRightContainQ = doesTreeContainNode(root.right, q);
        }

        /* brute force approach is 
         * check if root.contains(p and q)
         * check if root.left contains(p and q)
         * check if root.right contains p and q
         * if (root.contains is true but both root.left and root.right are false,
         * that is the answer).
         */
        
        boolean rootContainsPandQ = doesRootContainP && doesRootContainQ;
        boolean doesLeftContainPandQ = doesLeftContainP && doesLeftContainQ;
        boolean doesRightContainPandQ = doesRightContainP && doesRightContainQ;

        System.out.println("Root = " + root.val);
        System.out.println("Root.left contains P and Q " + doesLeftContainPandQ);
        System.out.println("Root.right contains P and Q " + doesRightContainPandQ);
        if (rootContainsPandQ && doesLeftContainPandQ) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (rootContainsPandQ && doesRightContainPandQ) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
    
    public boolean doesTreeContainNode(TreeNode root, TreeNode m) {
        if (root == null) {
            System.out.println("\tRoot is null so false");
            return false;
        }
        System.out.println("Start processing of root.val " + root.val + " contains m.val " + m.val);
        if (root.val == m.val) {
            System.out.println("End processing of root.val " + root.val + " contains m.val " + m.val);
            System.out.println("\tResult is true");
            return true;
        } else {
            boolean result = doesTreeContainNode(root.left, m) || doesTreeContainNode(root.right, m);
            System.out.println("End processing of root.val " + root.val + " contains m.val " + m.val);
            System.out.println("\tResult is " + result);
            return result;
        }
    }
}
