class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        st = []
        for i in range(0,len(tokens)):
            if(tokens[i].lstrip("-").isdigit()):
                st.append(int(tokens[i]))
            elif(tokens[i]=="+"):
                z1 = st.pop()
                z2 = st.pop()
                st.append(z1+z2)
            elif(tokens[i]=="-"):
                z1 = st.pop()
                z2 = st.pop()
                st.append(z2-z1)
            elif(tokens[i]=="*"):
                z1 = st.pop()
                z2 = st.pop()
                st.append(z1*z2)
            elif(tokens[i]=="/"):
                z1 = st.pop()
                z2 = st.pop()
                st.append(int(z2/z1))
        
        return st[-1]
