class Solution:
    # TC : O(n)
    # SC: O(n)
    def evalRPN(self, tokens: List[str]) -> int:
        st = []
        for token in tokens:
            if token == "+":
                val1 = st.pop()
                val2 = st.pop()
                st.append(val2+val1)
            elif token == "-":
                val1 = st.pop()
                val2 = st.pop()
                st.append(val2-val1)
            elif token == "*":
                val1 = st.pop()
                val2 = st.pop()
                st.append(val2*val1)
            elif token == "/":
                val1 = st.pop()
                val2 = st.pop()
                st.append(int(val2/val1))
            else:
                st.append(int(token))
        return st[-1]
        
