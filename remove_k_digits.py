#Time Complexity: O(N)
#Space Complexity: O(N) 
class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        stack = []
        result = []
        for digit in num:
            d = int(digit)
            while k and stack and stack[-1]>d:
                stack.pop()
                k-=1
            stack.append(d)
        
        if k:
            while(stack and k):
                stack.pop()
                k-=1
        while(stack):
            item = stack.pop()
            result.insert(0,item)

        if len(result)==0:
            return '0'
        else:
            idx = -1
            for index,item in enumerate(result):
                if item != 0:
                    idx = index
                    break
            if idx == -1:
                return '0'
            return ''.join([str(elem) for elem in result[idx:]])
            # ÷return ''.join(result[idx:])
                    
            
        