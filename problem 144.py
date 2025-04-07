#  https://leetcode.com/problems/evaluate-reverse-polish-notation/

class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        n = len(tokens)
        stack = []

        for i in range(n):
            if tokens[i] != "+" and tokens[i] != "-" and tokens[i] != "*" and tokens[i] != "/":
                num = int(tokens[i])
                print(num)
                stack.append(num)
            
            else:
                second = stack.pop()
                first = stack.pop()
                if tokens[i] == "+":
                    ans = first + second
                    print(ans)
                    stack.append(ans)

                elif tokens[i] == "-":
                    ans = first - second
                    print(ans)
                    stack.append(ans)

                elif tokens[i] == "*":
                    ans = first * second
                    print(ans)
                    stack.append(ans)

                else:
                    ans = int(first / second)
                    print(ans)
                    stack.append(ans)
        
        return stack.pop()

# TC: O(n)
# SC: O(n)
                