class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        st=[]
        for i in tokens:
            if i=='+':
                p=int(st.pop())
                q=int(st.pop())
                st.append(q+p)
                
            elif i=="-":
                p=int(st.pop())
                q=int(st.pop())
                st.append(q-p)
                
            elif i=="*":
                p=int(st.pop())
                q=int(st.pop())
                st.append(q*p)
                
            elif i=="/":
                p=int(st.pop())
                q=int(st.pop())
                st.append(int(q/p))    
                
            else:
                st.append(i)
        return st.pop()
