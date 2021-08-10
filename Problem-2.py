"""
Approach 1: using stack
* two pointers cannot be used here since the middle elements between start and end points can also be eliminated

1) push the chars such that the minimum value sequence is maintained in the stack
    a) make sure that you do not eliminate more than k elements
2) now rebuild string from stack and add the rest of the elements
    a) also note that you need n-k elements in your final string
3) strip leading zeros

TC: O(n + k)
SC: O(n)
"""

from collections import deque
class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        n = len(num)
        stack = deque()
        stack.append(num[0])
        i = 1
        while i<n and k>0: 
            char = num[i]
            if stack and int(char) < int(stack[-1]):
                stack.pop()
                k -= 1
            else:
                stack.append(char)
                i += 1
        
        result = []
        while stack:
            result.append(stack.pop())
        
        result = result[::-1] # need to reverse because you have pulled the chars in the reverse order from stack
        
        while i<n: # add remaining chars
            result.append(num[i])
            i += 1
        
        while k: # final string should be n-k or "0"
            result.pop()
            k -= 1
        
        result = "".join(result)
        
        if len(result) > 1:
            result = result.lstrip('0')
        if not result: # do not use else because result can become empty after removing leading zeroes
            result = "0"
        return result
        
            