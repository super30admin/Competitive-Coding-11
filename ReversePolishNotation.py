# // Time Complexity : o(n)
# // Space Complexity : o(1)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach
# keep iterating stack as u see a operation pop from stack and evaluate

from typing import List
class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        st = []
        for c in tokens:
            if c == '+':
                st.append(st.pop()+st.pop())
            elif c == '*':
                st.append(st.pop()*st.pop())
            elif c == '-':
                a,b = st.pop(),st.pop()
                st.append(b-a)
            elif c == '/':
                a,b = st.pop(), st.pop()
                st.append(int(b/a))
            else:
                st.append(int(c))
        return st[0]
            