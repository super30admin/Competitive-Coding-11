
# // Time Complexity :O(2n+k)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach
class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        
        i=1
        st=[]
        for i in num:
            while st and k>0 and int(st[-1])>int(i):
                st.pop()
                k-=1
            st.append(i)
        for i in range(k):
            st.pop()
        print(st)
        retstrng=''.join(st).lstrip('0')
        if not retstrng:
            return '0'
        return retstrng
        
            
        