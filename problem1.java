package Competitive-Coding-11;
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class problem1 {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        
     
         List<Integer> l;
        TreeNode curr=root;
        
        while(curr.left!=null || curr.right!=null){
            
            l=new ArrayList<>();
            helper(curr, l);
            
            ans.add(l);
            
        }
        l=new ArrayList<>();
        l.add(curr.val);
        ans.add(l);
        
        return ans;
        
    }
    public void helper(TreeNode root, List<Integer> l ){
       if(root==null){return;}
      if(root.left!=null && root.left.left==null && root.left.right==null){
          l.add(root.left.val);
          root.left=null;
      }
        if(root.right!=null && root.right.left==null && root.right.right==null){
          l.add(root.right.val);
          root.right=null;
      }
        helper(root.left,l);
        helper(root.right,l);
        
    }
}
