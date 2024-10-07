class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        
       # maintain monotonic stack of icreasinng integers
        stack = []
        for i in num:
            while stack and k > 0 and stack[-1] > i:
                stack.pop()
                k -=1
            if not stack and i == "0":
                continue
            stack.append(i)
        #print(stack)
        stack = stack[:len(stack) - k]

        #print(stack)

        res = "".join(stack)

       # print(stack)
        return res if res else "0"

### T(C): O(n)
### S(C): O(n)
