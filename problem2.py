#Time, space O(n)
class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        st=[]

        #Appending numbers and popping if there is expression and evaluating the res
        for t in tokens:
            if t not in "+-*/":
                st.append(int(t))
                continue

            n2=st.pop()
            n1=st.pop()
            res=0
            if t == "+":
                res = n1 + n2
            elif t=="-":
                res= n1 - n2 
            elif t=="*":
                res = n1 * n2
            elif t == "/":
                res = int(n1/n2)
             
            st.append(res)
            
        return st.pop()
                
        
