
"""
time: O(N)
space: O(N)
"""

class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        st = []
        for  idx, num in enumerate(tokens):
            
            if num == "+":
                s = st.pop()
                t = st.pop()
                st.append(int(s)+int(t))
            elif num == "-":
                s = st.pop()
                t = st.pop()
                st.append(int(t)-int(s))
                
            elif num == "*":
                s = st.pop()
                t = st.pop()
                st.append(int(s)*int(t))
              
            elif num == "/":
                s = st.pop()
                t = st.pop()
                st.append(int(int(t)/int(s)))
          
           
            else: st.append(num)
            
        return st.pop()