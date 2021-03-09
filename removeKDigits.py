# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        stack = []
        for i in num:
            while stack and k > 0 and stack[-1] > i:
                stack.pop()
                k -= 1
            stack.append(i)
        
        for i in range(k):
            stack.pop()
            
        res = ''.join(stack).lstrip('0')
        
        if not res:
            return '0'
        return res