#Time O(n), space O(n)
class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        
        st=[]
        
        #Pushing in the stack and popping if the incoming element is lesser than the stack top if k is zero returning all the elements in the stack otherwise truncating k
        for i in num:
            
            while k and st and st[-1]>i:
                st.pop()
                k-=1
                
            st.append(i)
     
        if k: 
            f=st[:-k]    
        else:
            f= st
        
        return "".join(f).lstrip('0') or "0"
