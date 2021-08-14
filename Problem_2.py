from typing import List
from collections import deque
class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        stack = deque()
        for digit in num:
            while stack and k > 0 and stack[-1] > digit:
                k -= 1
                stack.pop()
            stack.append(digit)
        
        for i in range(k):
            stack.pop()
        
        string = ''.join(stack).lstrip('0')
        
        if string == '':
            return "0"
        else:
            return string

# Time Complexity: O(2n + k) => O(n)
# Space Complexity: O(n)