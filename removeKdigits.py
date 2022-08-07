#Time complexity: O(n)
#space complexity: O(n)
class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        if len(num) <= k:
            return "0"
        
        st = []
        st.append((num[0]))
        
        
        for i in range(1, len(num)):
            while st and k > 0 and st[-1] > (num[i]):
                st.pop()
                k -= 1
            st.append((num[i]))
            
        while k > 0 and st:
            st.pop()
            k -= 1
        
        if not st:
            return "0"
        
        return (str(int("".join(st))))
            
            
        
