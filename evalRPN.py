"""
Time complexity O(N)
Space complexity 0(N) (stack)

Push when you see digit into stack and pop top two elements froms tack when you see operator. Perform the opeartion and push result back to stack
"""
class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        #if not tokens:
            #return 0
        
        st=[]
        operator={'+',"-","*","/"}
        for ch in tokens:
            if ch in operator:
                num1=int(st.pop())
                num2=int(st.pop())
                if ch=='+':
                    st.append(num2+num1)
                elif ch=="*":
                     st.append(num2*num1)
                elif ch=="-":
                    st.append(num2-num1)
                elif ch=="/":
                    st.append(num2/num1)
            else:
                st.append(ch)
        return int(st.pop()) #final answer will be at top of stack and only element 
        
        