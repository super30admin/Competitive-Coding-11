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
// Approach : DFS (Recursion) and calculate hieght of everynode
// Time: O(n)
// Space : O(h) 
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> findLeaves(TreeNode root) {
        this.result = new ArrayList<>();
        if(root == null){
            return result;
        }
        dfs(root);
        return result;
    }

    public int dfs(TreeNode root){
        // Base case
        if(root == null){
            return -1;
        }

        // Logic
        int leftHeight = dfs(root.left);
        int rightHeight = dfs(root.right);

        int currHeight = 1+Math.max(leftHeight , rightHeight); // leaf node = 0

        if(result.size() == currHeight){
            result.add(new ArrayList<>());
        }
        result.get(currHeight).add(root.val);

        return currHeight;

    }
}