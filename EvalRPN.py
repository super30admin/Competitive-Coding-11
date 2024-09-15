-------------------------Eval RPN------------------------------------------
# Time Complexity : O(n) as N is length of string 
# Space Complexity : O(n)  as we are using stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# We will iterate through string and if the number is digit then we will append to the stack else if it is operator, then we will
# pop the top 2 elements from the stack based on the operator we will add them/subtract/multiply/divide them and add them to the stack again.



class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        st=[]
        for i in tokens:
            if i in ('+','-','*','/'):
                b=st.pop(-1)
                a=st.pop(-1)
                if i=='+':st.append(a+b)
                elif i=='-':st.append(a-b)
                elif i=='*':st.append(a*b)
                else:
                    d=a//b
                    if d<0:
                        st.append(-1*(-a//b))
                    else:
                        st.append(d)
            else:st.append(int(i))
        return st[0]