# STEPS:
# Evaluate the tokens in the Postfix notation using stacks.
# Push the elements to the stack.
# When an operation is encountered, pop the two top most elements from the stack, and evaluate it.
# append the result to the stack.
# at the end, return the topmost element from the stack as a result.
# Time complexity - O(n) # at most O(2n)
# Space complexity - O(n)
# Did this solution run on leetcode? - Yes
# Did you encounter any issues while running this? - No
from collections import deque
class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        if not tokens: return
        s = deque()
        for token in tokens:
            if token not in "+-*/":
                s.append(int(token))
                continue
            
            secondelem = s.pop()
            firstelem = s.pop()
            op = "{}{}{}".format(firstelem, token, secondelem)
            s.append(int(eval(op)))
        
        return s.pop()