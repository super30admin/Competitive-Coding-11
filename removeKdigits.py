"""
TC O(2N+K)
sc 0(N)
 greedy + stack 
"""

class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        st=[]
        for dig in num:
            while st and k>0 and st[-1]>dig:
                k-=1
                st.pop()
            st.append(dig)
        
        
        #15234 k=2
        for i in range(k):
            st.pop()
        
        res="".join(st).lstrip("0")
        
        if not res:
            return '0'
        
        return res