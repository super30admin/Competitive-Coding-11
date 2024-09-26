class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        if(k==0):
            return num
        if(len(num)==1 and k==1):
            return "0"
        st = []
        o = []
        i=0
        while(i<len(num)):
            while(k>0 and len(st)>0 and int(num[i])<int(st[-1])):
                st.pop()
                k-=1
            st.append(num[i])
            i+=1
        
        st = st[:-k] if k>0 else st
        
        return "".join(st).lstrip('0') or "0"
