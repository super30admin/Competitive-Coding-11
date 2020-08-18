"""
// Time Complexity : o(n)
// Space Complexity : o(n), stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
"""
class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        if not tokens:
            return 0
        st = []
        
        for i in tokens:
            
                if i == "+" :
                    sec = st.pop()
                    first = st.pop()
                
                    res = sec + first
                    st.append(res)
                elif i == "*":
                    sec = st.pop()
                    first = st.pop()
                
                    res = sec * first
                    st.append(res)
                    
                elif i == "-":
                    sec = st.pop()
                    first = st.pop()
                
                    res = first - sec
                    st.append(res)
                
                elif i == "/":
                    sec = st.pop()
                    first = st.pop()
                
                    res = first//sec
                    st.append(res)
                
                else:
                    st.append(int(i))
                    
                
                
        return st[-1]