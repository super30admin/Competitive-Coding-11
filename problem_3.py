"""
Time Complexity : O(n)- number of nodes
Space Complexity : O(n)- for the hashmap
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : no

Here, we need to find the depth of each node, which would be 1 plus the depth of the parent node. Also, we would be storing depth 
of each node in a hashmap so that we do not need to calculate it the next time we need it. After we have found our depths,
the next thing we need to find is that which node has left and right with maximum depth, that would be our answer. If, both
left and right are not present, then instead of root, those left and right would be that subtree.
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Solution:
    def findDepth(self, root, parent=None):
        if root:
            self.depthMap[root] = self.depthMap[parent]+1
            self.findDepth(root.left, root)
            self.findDepth(root.right, root)

    def findNode(self, root, maximum):
        if not root or self.depthMap[root] == maximum:
            return root
        left = self.findNode(root.left, maximum)
        right = self.findNode(root.right, maximum)
        if left and right:
            return root
        else:
            return left or right

    def subtreeWithAllDeepest(self, root: TreeNode) -> TreeNode:
        self.depthMap = {None: -1}
        self.findDepth(root)
        maximum = max(self.depthMap.values())
        return self.findNode(root, maximum)
