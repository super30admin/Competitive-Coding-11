import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//use bfs inorder traversal, while adding into the answer list,
//reverse the array for odd index of the answer array

  //Definition for a binary tree node.
 public class TreeNode {
      int val;
   TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
         this.left = left;
         this.right = right;
    }
  }

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans= new ArrayList<>();
        if(root == null) return ans;
        int count=0;
        Queue<TreeNode> queue= new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> sub= new ArrayList<>();
            int size= queue.size();
            for(int i=0; i<size; i++){
                TreeNode newnode = queue.poll();           
                if(newnode!= null){
                sub.add(newnode.val);
                queue.add(newnode.left);
                queue.add(newnode.right);
                }
            }
            if(sub.size()>0){
                if(count%2 != 0){
                    Collections.reverse(sub);
                }
             ans.add(sub); 
            }
            count ++;
            
        }
        return ans;
    }
}