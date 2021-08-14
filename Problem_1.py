from typing import List
from collections import deque
class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        if tokens == None or len(tokens) == 0:
            return 0
        st = deque()
        result = 0
        for token in tokens:
            if token == "+" or token == "-" or token == "*" or token == "/":
                num2 = st.pop()
                num1 = st.pop()
                if token == "+":
                    result = num1 + num2
                elif token == "-":
                    result = num1 - num2
                elif token == "*":
                    result = num1 * num2
                else:
                    result = int(num1 / num2)
                st.append(result)
                
            else:
                st.append(int(token))
            
        return st[-1]

# Time Complexity: O(n)
# Space Complexity: O(n)