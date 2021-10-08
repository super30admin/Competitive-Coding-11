#time-O(n)
#space-O(n)
class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        l=[]
        for i in num:
            while k and l and l[-1]>i:
                l.pop()
                k=k-1
            l.append(i)
       
        if k!=0:
            l=l[:-k]
        ans=''.join(l).lstrip('0')
        if ans=='':
            return '0'
        else:
            return ans
