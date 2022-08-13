""""// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""


class Solution:
    def evalRPN(self, tokens: List[str]) -> int:

        h = set()
        h.add('+')
        h.add('-')
        h.add('*')
        h.add('/')

        st = []

        for i in tokens:
            if i in h:
                if i == '+':
                    x = st.pop()
                    y = st.pop()
                    temp = x + y
                    st.append(temp)
                elif i == '-':
                    x = st.pop()
                    y = st.pop()
                    temp = y - x
                    st.append(temp)
                elif i == '*':
                    x = st.pop()
                    y = st.pop()
                    temp = x * y
                    st.append(temp)
                elif i == '/':
                    x = st.pop()
                    y = st.pop()
                    st.append(int(y / x))
            else:
                st.append(int(i))
        return st[-1]

