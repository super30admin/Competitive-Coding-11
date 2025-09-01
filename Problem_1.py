from typing import List

def evalRPN(tokens: List[str]) -> int:
    '''
    150 Evaluate Reverse Polish Notation
    https://leetcode.com/problems/evaluate-reverse-polish-notation/description/

    Solution:
    1.  Consider "3, 4, -". First the 3 is pushed into the stack, then the 4; the 4 is now on top and the 3 below it. The subtraction operator removes the top two items from the stack, performs 3 - 4 = -1. The result (-1) is pushed into the stack.

    Time: O(N), Space: O(N)

    '''
    if not tokens:
        return 0
    stack = []
    operators = {'+', '-', '*', '/'}
    for t in tokens:
        if t in operators:
            num2 = stack.pop()
            num1 = stack.pop()
            result = 0
            if t == '+':
                result = num1 + num2
            elif t == '-':
                result = num1 - num2
            elif t == '*':
                result = num1 * num2
            elif t == '/':
                result = int(num1 / num2)
            else:
                raise(f"Invalid operator {t}")
            # print(f"{num1} {t} {num2} = {result}")
            stack.append(result)
        else:
            num = int(t)
            stack.append(num)
        # print(f"stack: {stack}")
    return stack.pop()

def run_evalRPN():
    tests = [(["2","1","+","3","*"], 9),
             (["4","13","5","/","+"], 6),
             (["10","6","9","3","+","-11","*","/","*","17","+","5","+"], 22),
    ]
    for test in tests:
        tokens, ans = test[0], test[1]
        result = evalRPN(tokens)
        print(f"\ntokens = {tokens}")
        print(f"result = {result}")
        success = (ans == result)
        print(f"Pass: {success}")
        if not success:
            print(f"Failed")
            return

run_evalRPN()