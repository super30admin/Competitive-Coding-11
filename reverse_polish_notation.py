#Time Complexity: O(N)
#Space Complexity: O(N) 

class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        for item in tokens:
            if item.isdigit() or item.strip('-').isdigit():
                stack.append(int(item))
           
            else:
                
                b =  stack.pop()
                a = stack.pop()
                #perform operation
                if item == '+':
                    result = a+b
                elif item =='-':
                    result = a-b
                elif item =='*':
                    result = a*b
                else:
                    result = int(a/b)

                stack.append(result)

        return stack.pop()
