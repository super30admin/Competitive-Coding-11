//TC: O(n)
//SC: O(height of tree)
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> findLeaves(TreeNode root) {
        result = new ArrayList<>();
        dfs(root, 0);
        return result;
    }
    
    private int dfs(TreeNode root, int depth){
        //base
        if(root == null) return -1;
        if(depth == result.size()) {
            result.add(new ArrayList<>());
        }
        
        //logic
        int left = dfs(root.left, depth+1);
        int right = dfs(root.right, depth+1);
        int height = Math.max(left, right) +1;
        result.get(height).add(root.val);
        return height;
        
    }
}
