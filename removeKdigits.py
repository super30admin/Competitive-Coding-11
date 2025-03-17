class Solution:
    # TC : O(n)
    # SC : O(n)
    def removeKdigits(self, num: str, k: int) -> str:
        if num is None or len(num) == 0:
            return "0"
        if k == 0:
            return num
        st = []
        for i in num:
            while len(st) > 0 and k > 0 and i < st[-1]:
                st.pop()
                k -= 1
            st.append(i)
        while k > 0:
            st.pop()
            k -= 1
        if len(st) == 0:
            return "0"

        res = ''.join(st)
        index = 0
        while index < len(res) and res[index] == '0':
            index += 1
        res = res[index:]
        
        return res if res else "0"