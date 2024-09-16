// Time Complexity : O(N)
// Space Complexity : O(1)
//Problem: https://leetcode.com/problems/find-leaves-of-binary-tree/

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

    List<List<Integer>> master = new ArrayList<>();

    public List<List<Integer>> findLeaves(TreeNode root) {
        helper(root);
        return master;
    }

    private int helper(TreeNode root){

        if(root == null){
            return -1;
        }

        int leftH = helper(root.left) + 1;
        int rightH = helper(root.right) + 1;

        int rootH = Math.max(leftH, rightH);

        if(master.size() == rootH){
            master.add(new ArrayList<>());
        }

        master.get(rootH).add(root.val);

        return rootH;
    }
}