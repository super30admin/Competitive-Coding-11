'''
time complexity: O(n)
space complexity: O(n)
'''
class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        st = []
        for i in range(len(tokens)):
            
            if tokens[i]=="+":
                num1 = st.pop()
                num2 = st.pop()
                st.append(num1+num2)
            elif tokens[i]=="-":
                num1 = st.pop()
                num2 = st.pop()
                st.append(num2-num1)
            elif tokens[i]=="*":
                num1 = st.pop()
                num2 = st.pop()
                st.append(num2*num1)
            elif tokens[i]=="/":
                num1 = st.pop()
                num2 = st.pop()
                st.append(int(num2/num1))
            else:
                st.append(int(tokens[i]))
        return st[0]