"""
# Time complexity - O(n) 
# Space Complexity: O(n)
# Did this code successfully run on LeetCode?: Yes
# Problems faced while coding this:None
Approach: Using stack:
    append stack unless the values are smaller than the current element
    if current element is smaller than top of the stack, then remove that number and decrement k value by 1
    pop elements until k becomes 0 (in case after visiting each element the length of the stack is larger than req)
    lastly take care of leading 0's
"""

class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        numStack = []
        
        for digit in num:
            #print(numStack)

            while k and numStack and numStack[-1] > digit:
                numStack.pop()
                k -= 1
            numStack.append(digit)
        
        final = numStack[:-k] if k else numStack
        
        # leading zeros
        return "".join(final).lstrip('0') or "0"