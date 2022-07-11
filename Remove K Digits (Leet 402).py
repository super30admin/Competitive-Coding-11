'''
Using Monotonic Stacks
Time: O(n)
Space: O(n)
'''

class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        
        st = list()
        st.append(int(num[0]))
        
        for ch in range(1,len(num)):
            n = int(num[ch])
            while len(st) > 0 and st[-1] > n and k != 0:
                st.pop()
                k -= 1
            st.append(n)
        
        while k != 0:
            st.pop()
            k-=1
        
        res = ''
        
        while len(st) != 0:
            res = str(st.pop()) + res
        
        res = res.lstrip('0')
        return res if res != '' else '0'
        
        