#Time: O(n)
#Space: O(n)
#Program ran on leetcode successfully

class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []


        for t in tokens:
            if t.lstrip("-").isdigit():
                print(t)
                stack.append(int(t))
            else:
                num_1 = stack.pop()
                num_2 = stack.pop()
                if t == '+':
                    new_num = num_1 + num_2
                elif t == '-':
                    new_num = num_2 - num_1
                elif t == '*':
                    new_num = num_1 * num_2
                else:
                    new_num = num_2 / num_1
                
                stack.append(int(new_num))
        
        return stack.pop()


        