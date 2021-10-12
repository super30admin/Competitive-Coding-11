"""
Time Complexity : O(n) where n is the no. of digits in num array
Space Complexity : O(n) where n is the no. of digits in num array
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        if len(num) == k:
            return "0"
        stack = []
        for n in num:
            while k and stack and stack[-1] > n:
                if stack[-1] > n:
                    stack.pop()
                    k -= 1
            stack.append(n)
        if k:
            stack = stack[:-k]
        
        return "".join(stack).lstrip('0') or "0"