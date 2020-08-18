"""
// Time Complexity : o(n)
// Space Complexity : o(n), stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
"""
class Solution(object):
    def removeKdigits(self, num, k):
        """
        :type num: str
        :type k: int
        :rtype: str
        """
        
        stack = []
        for each in num:   
            while k and stack and stack[-1] > each:
                stack.pop()
                k -= 1
            stack.append(each)
    
        while k>0:
            stack.pop()
            k -= 1
    
        output = "".join(stack).lstrip("0")
        return (output if output else "0")
            
            