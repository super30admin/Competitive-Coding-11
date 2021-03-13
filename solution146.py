#Time Complexity:O(n)
#Space Complexity:O(n)
class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        st=[]                                               #push all characters of th string into avstack . if a character is greater than ts next , pop from stack
        for digit in num:
            while st and k>0 and st[-1]>digit:
                k-=1
                st.pop()
            st.append(digit)
        for i in range(k):                                 #if k is not zero pop from stack until k is zero
            st.pop()
        reNum=''.join(st).lstrip('0')                      #return the string without leading zeros
        if not reNum:
            return '0'                                     
        return reNum