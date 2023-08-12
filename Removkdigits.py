# Time complexity - O(n)
#  Space complexity - O(n)
class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        st=[]
        for i in num:
            while st and k>0 and st[-1]>i:
                k-=1
                st.pop()
            st.append(i)

        for i in range(k):
            st.pop()
            
        retst=''.join(st).lstrip('0')
        if not retst:
            return '0'
        return retst