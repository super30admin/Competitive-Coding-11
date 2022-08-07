#Time complexity: O(n)
#Space complexity: O(n)

class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        st = []
        
        for token in tokens:
            if token == "+":
                n1 = st.pop()
                n2 = st.pop()
                st.append(n1+n2)
            elif token == "-":
                n1 = st.pop()
                n2 = st.pop()
                st.append(n2-n1)
            elif token == "*":
                n1 = st.pop()
                n2 = st.pop()
                st.append(n1*n2)
            elif token == "/":
                n1 = st.pop()
                n2 = st.pop()
                st.append(int(n2/n1))
            else:
                st.append(int(token))
                
        return st[-1]
            
                
        
