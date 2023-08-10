# Time Complexity : O(n)
# Space Complexity :O(n)
# Passed on Leetcode: yes

class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        stack = []
        
        for digit in num:
            # Pop digits from the stack if they are greater than the current digit
            while k > 0 and stack and stack[-1] > digit:
                stack.pop()
                k -= 1
            stack.append(digit)
        
        # Remove remaining digits if k is still greater than 0
        while k > 0:
            stack.pop()
            k -= 1
        
        # Convert the stack to a string, remove leading zeros
        result = ''.join(stack).lstrip('0')
        
        # Return '0' if the result is empty, else return the result
        return result if result else '0'
