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
        # We traverse through string of digits and we compare the topmost element with 
        # the current element we are at, if the stack element is greater than the 
        # current element we pop from the stack and decrement k. In all other cases we
        # append the digits to the stack. At the end if k is not zero we return the 
        # first k elements from the stack. In other cases we strip leading 0 from the
        # string and return.
        for n in num:
            while k and stack and stack[-1] > n:
                if stack[-1] > n:
                    stack.pop()
                    k -= 1
            stack.append(n)
        if k:
            stack = stack[:-k]
        
        return "".join(stack).lstrip('0') or "0"