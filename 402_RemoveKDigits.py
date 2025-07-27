"""
TC: O(N)
SC: O(N)
Logic:
Use stack. Push to stack if stack is empty or top of stack lesser than current element.
If not, pop the elements, but keep track of how many elements were popped. Pop only till k becomes 0
Strip off 0 if first element is 0
if k>0, take first k elements from stack
"""
class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        st = []
        for i in num:
            while (st and st[-1] > i and k > 0):
                st.pop()
                k -= 1
            st.append(i)
        st = st[:-k] if k > 0 else st
        st = "".join(st).lstrip('0')
        return st if st else "0"
