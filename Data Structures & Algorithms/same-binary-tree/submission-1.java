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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        ArrayList<String> preOrderTraversalP = new ArrayList<String>();
        ArrayList<String> postOrderTraversalP = new ArrayList<String>();
        ArrayList<String> inOrderTraversalP = new ArrayList<String>();

        ArrayList<String> preOrderTraversalQ = new ArrayList<String>();
        ArrayList<String> postOrderTraversalQ = new ArrayList<String>();
        ArrayList<String> inOrderTraversalQ = new ArrayList<String>();

        preOrderTraversalP.addAll(preOrderTraversal(p, new ArrayList<String>()));
        preOrderTraversalQ.addAll(preOrderTraversal(q, new ArrayList<String>()));

        if (!preOrderTraversalP.equals(preOrderTraversalQ)) {
            System.out.println("Pre");
            System.out.println(preOrderTraversalP);
            System.out.println(preOrderTraversalQ);
            return false;
        }

        postOrderTraversalP.addAll(postOrderTraversal(p, new ArrayList<String>()));
        postOrderTraversalQ.addAll(postOrderTraversal(q, new ArrayList<String>()));

        if (!postOrderTraversalP.equals(postOrderTraversalQ)) {
            System.out.println("Post");
            System.out.println(postOrderTraversalP);
            System.out.println(postOrderTraversalQ);
            return false;
        }
        
        inOrderTraversalP.addAll(inOrderTraversal(p, new ArrayList<String>()));
        inOrderTraversalQ.addAll(inOrderTraversal(q, new ArrayList<String>()));

        if (!inOrderTraversalP.equals(inOrderTraversalQ)) {
            System.out.println("In");
            System.out.println(inOrderTraversalP);
            System.out.println(inOrderTraversalQ);
            return false;
        }
        return true;

    }
    public ArrayList<String> preOrderTraversal(TreeNode root, ArrayList<String> preOrderList) {
        if (root == null) {
            preOrderList.add("null");
            return preOrderList;
        }
        preOrderList.add(Integer.toString(root.val));
        preOrderList.addAll(preOrderTraversal(root.left, new ArrayList<String>()));
        preOrderList.addAll(preOrderTraversal(root.right, new ArrayList<String>()));
        return preOrderList;
    }

    public ArrayList<String> postOrderTraversal(TreeNode root, ArrayList<String> postOrderList) {
        if (root == null) {
            postOrderList.add("null");
            return postOrderList;
        }
        postOrderList.addAll(postOrderTraversal(root.left, new ArrayList<String>()));
        postOrderList.addAll(postOrderTraversal(root.right,new ArrayList<String>()));
        postOrderList.add(Integer.toString(root.val));
        return postOrderList;
    }

    public ArrayList<String> inOrderTraversal(TreeNode root, ArrayList<String> inOrderList) {
        if (root == null) {
            inOrderList.add("null");
            return inOrderList;
        }
        inOrderList.addAll(inOrderTraversal(root.left,new ArrayList<String>()));
        inOrderList.add(Integer.toString(root.val));
        inOrderList.addAll(inOrderTraversal(root.right,new ArrayList<String>()));
        
        return inOrderList;
    }
}
