# Time Complexity: O(n)
# Space Complexity: O(n)
class Solution(object):
    def removeKdigits(self, num, k):
        """
        :type num: str
        :type k: int
        :rtype: str
        """
        if k >= len(num):
            return "0"
        
        stack = []
        
        for i in range(len(num)):
            while stack and k and num[i] < stack[-1]:
                stack.pop()
                k -= 1
            stack.append(num[i])
            
        while k:
            stack.pop()
            k -= 1
            
        return "".join(stack).lstrip('0') or '0'