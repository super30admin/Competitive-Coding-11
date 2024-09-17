'''
Using Stack
Time: O(n)
Space: O(n)
'''

class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        
        res = 0
        
        st = list()
        
        for di in tokens:
            if di.lstrip('-').isdigit():
                st.append(int(di))
            else:
                a = st.pop()
                b = st.pop()
                ch = di
                if ch == '+':
                    st.append(b+a)
                elif ch == '-':
                    st.append(b-a)
                elif ch == '*':
                    st.append(b*a)
                else:
                    st.append(int(b/a))
        return st[-1]