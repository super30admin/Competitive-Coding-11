// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

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