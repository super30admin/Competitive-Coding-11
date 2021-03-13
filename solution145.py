#Time Complexity:O(n)
#Space Complexity:O(n)
class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        st=[]
        for ch in tokens:                   #parse through the list 
            if ch.lstrip('-').isdigit():    #if character is a number, append to stack
                st.append(int(ch))
            else:
                b=st.pop()                  #else obtain the last two numbers from the stack
                a=st.pop()
                if ch=='+':                 #perform the arithmetic funtion using the two numbers based on the arithmetic operator.
                    exp=a+b
                elif ch=='-':
                    exp=a-b
                elif ch=='*':
                    exp=a*b
                else:
                    exp=a/b
                st.append(int(exp))         #append the arithmetic expression result into the stack
        return st.pop()                     #after the list is processed return the final result.