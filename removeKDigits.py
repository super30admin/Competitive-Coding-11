# Approach - Traverse from left to right, so that removing k digits will more likely result in smaller numbers
# Repeat until stack is empty and as long as K is not zero
# If K is still not zero - in case of increasing sequences, then slice values in stack up until k to rmeove k larger numbers
# In the end, strip and leading zeros and return values in stack

# time - O(N)
# space - O(N)

class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        
        st = []
        
        for digit in num:
            
            while k and st and st[-1] > digit:
                
                st.pop()
                k -= 1
                
            st.append(digit)
        
        
        st = st[:-k] if k else st
      
        return "".join(st).lstrip('0') or '0'



## In place of in built function lstrip
    res =  "".join(st)
    output = ""
    found = False
    for digit in res:
        if digit == '0' and found is False:
            continue
            
        found = True

        output += digit
        
    return output  