# Problem 2: Remove K Digits
class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        st = []
        result = ""

        if k >= len(num): return "0"

        for n in num:
            while k > 0 and st and n < st[-1]:
                st.pop()
                k -= 1
            st.append(n)

        while k > 0:
            st.pop()
            k -= 1

        result = ''.join(st)
        result = result.lstrip('0')

        return "0" if result == "" else result

        

        