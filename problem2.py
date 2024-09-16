#remove k digits from string
class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
       # num=int(num)
        numstack=[]
        print(num[-1])
        for dig in num:
            
            while k and numstack and numstack[-1]>dig:
                numstack.pop()
                k-=1
            numstack.append(dig)
        
        full=numstack[:-k] if k else numstack
       
        out="".join(full).lstrip("0")
        return "0" if len(out)==0 else out