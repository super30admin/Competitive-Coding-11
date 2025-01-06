# Approach:
# We will use a stack to keep track of the digits in the smallest possible order while iterating through the string.
# Remove digits from the stack when they are larger than the current digit, as they would increase the number.
# Ensure the stack has the smallest digits possible after removing `k` digits, and handle edge cases like leading zeroes.

# Time Complexity: O(n), where n is the length of the string `num`.
# Space Complexity: O(n) for the stack.
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: None

class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        # Edge case: If k is equal to the length of num, return "0"
        if k == len(num):
            return "0"
        
        stack = []  # To store the digits for the smallest number
        
        # Iterate through each digit in the number
        for digit in num:
            # While the stack is not empty, k > 0, and the top of the stack is greater than the current digit,
            # remove the top of the stack to maintain the smallest order
            while stack and k > 0 and stack[-1] > digit:
                stack.pop()
                k -= 1
            
            # Add the current digit to the stack
            stack.append(digit)
        
        # Remove any remaining digits from the end if k > 0
        while k > 0:
            stack.pop()
            k -= 1
        
        # Build the resulting number and remove leading zeroes
        result = ''.join(stack).lstrip('0')
        
        # If the result is empty after removing leading zeroes, return "0"
        return result if result else "0"
