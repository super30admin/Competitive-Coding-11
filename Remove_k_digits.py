#TC:O(n)
#Sc:O(n)
class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        stack = []
        n = len(num)
        if n<=0 or n==k:
            return "0"
        stack = []
        count=0
        stack.append(int(num[0]))
        i=1
        while(i<n):
            if stack:
                while stack and i<n and stack[-1]>int(num[i]) and count<k:
                    stack.pop()
                    count+=1
            stack.append(int(num[i]))
            # else:
            #     stack.append(int(num[i]))
            i+=1
        list_val=[]
        # print(stack)
        while(stack and count<k):
            stack.pop()
            count+=1
        while(stack):
            list_val.insert(0,str(stack.pop()))
        return str(int("".join(str(val) for val in list_val)))