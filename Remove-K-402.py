# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def removeKdigits(self, num, k):
        """
        :type num: str
        :type k: int
        :rtype: str
        """
        stack = []
        for n in num:
            while k > 0 and len(stack) > 0 and stack[-1] > n:
                k -= 1
                stack.pop()
            stack.append(n)
        
        
        if k > 0:
            stack = stack[:-k]
        
        return ''.join(stack).lstrip('0') or '0'
        