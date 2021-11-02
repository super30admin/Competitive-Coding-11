# // Time Complexity :O(n)
# // Space Complexity :O(n),height of stack
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach

class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        st=[]
        for i in tokens:
            if len(i)>1:
                temp=i[1:]
                
                
            else:
                temp=i
            if temp.isdigit():
                    st.append(int(i))
            
            else:
                a=st.pop()
                b=st.pop()
                if i == "/":
                    res=int(b/a)
                elif i=='*':
                    res=a*b
                elif i=='-':
                    res=b-a
                else:
                    res=a+b
                st.append(res)
        return st[0]
                    
                
                
        