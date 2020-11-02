// Time Complexity : O(n)
// Space Complexity : O(n)
// Any problem you faced while coding this :no


/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    vector<vector<int>> result;
	vector<int> temp_empty;
    vector<vector<int>> findLeaves(TreeNode* root) {
        if(root== NULL){
		return result;
	}
	int temp = recursion(root);
	
	
	return result;
    }
    	int recursion(TreeNode* root){
        if(root->left == NULL && root-> right == NULL){
            return 0;
        }
        int l = recursion(root-> left);
        int r = recursion(root->right);
        int res =max(l,r) + 1;
        while(!(result.size()-1 < res)){
		result.push_back(temp_empty);
	}
	
	
	result[res].push_back(root->val);
	return res;
    }
};