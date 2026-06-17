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
    public List<List<Integer>> levelOrder(TreeNode root) {
        /*
        * what i need is [1] [2 3] [4 5 6 7] as output
        to achieve that, i can see that i need to use queue
        if i just use a simple queue, i will go - 
        enque 1, then 1.left then 1.right
        so 1 -> 2 -> 3
        but this is missing when do i instantiate index to switch to new list
        this is basi BFS

        alternate approach is that i use a complex objet in the queue
        something like Map<Integer, Integer> where first is level and second is node.val
        even though this might work, we can not trust that hashmap will store objects sequentially
        maybe a 2-d array is more suited.
        queue of int[][] where first index is the level and secon index is the sequential element.
        
        For this example, it will become - 
        [0][1]
        [1][2],[1][3]
        [2][4],[2][5],[2][6],[2][7]

        Which is why the output is List of lists, so instead of 2-d array, i can have a list of lists.
        but the lists need to be array lists.
        then it goes like so - 
        
        List<List<Integer>> result = new list
        Queue<Node> bfsQ = new LinkedList
        
        while q is not empty {
            int numberOfElementsAtLevel = q.size();
            List<Integer> elementsAtLEvel = new ArrayList<>();
            for(int i == 0; i<numberOfElementsAtLevel; i++) {
                elementsAtLEvel.add(q.remove());
                if (q.left != null) {
                    elementsAtLEvel.add(q.left);
                } 
                if (q.right != null) {
                    elementsAtLEvel.add(q.right);
                }
            }
            result.add(elementsAtLevel);
        }
            
        */

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);

        while (!q.isEmpty()) {
            int numberOfElementsAtLevel = q.size();
            List<Integer> elementsAtLevel = new ArrayList<>();
            for (int i = 0; i < numberOfElementsAtLevel; i++) {
                TreeNode elementAtLevel = q.remove();
                if (elementAtLevel != null) {
                    elementsAtLevel.add(elementAtLevel.val);
                    if (elementAtLevel.left != null) {
                        q.add(elementAtLevel.left);
                    }
                    if (elementAtLevel.right != null) {
                        q.add(elementAtLevel.right);
                    }
                }
            }
            if(elementsAtLevel.size()>0)
                result.add(elementsAtLevel);
        }
        return result;
    }
}
