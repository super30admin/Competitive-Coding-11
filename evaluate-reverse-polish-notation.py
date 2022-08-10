# Time Complexity: O(n)
# Space Complexity: O(n)
class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        hset=set(('+','-','/','*'))
        stack=[]
        for c in tokens:
            if c in hset:
                first=stack.pop()
                second=stack.pop()
                if c=='+': stack.append(second+first)
                elif c=='-': stack.append(second-first)
                elif c=='*': stack.append(second*first)
                elif c=='/': stack.append(int(second/first))
            else:
                stack.append(int(c))
        return stack.pop()
                