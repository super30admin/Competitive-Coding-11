"""
Time Complexity : O(n+k)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : no
"""


class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        if not num or len(num) == 0:
            return num
        
        stack = []
        for i in range(len(num)):
            while k != 0 and stack and num[i] < stack[-1]:
                stack.pop()
                k -= 1
            stack.append(num[i])
        
        result = "".join(stack[:len(stack) - k]).lstrip("0")
        
        if len(result) != 0:
            return result
        return "0"
