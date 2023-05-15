# Time Complexity :  O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        operators = {"*","/","+","-"}
        stack = []
        for i in tokens:
            if i in operators:
                secelement = stack.pop()
                firstelement = stack.pop()
                if i == "*":
                    stack.append(secelement*firstelement)
                elif i == "/":
                    stack.append(int(firstelement/secelement))
                elif i == "+":
                    stack.append(firstelement+secelement)
                elif i == "-":
                    stack.append(firstelement-secelement)
            else:
                stack.append(int(i))
        return stack.pop()