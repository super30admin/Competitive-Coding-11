# Problem 1 - Evaluate Reverse Polish Notation
## Time Complexity :
O(n)

## Space Complexity :
O(n)

## Did this code successfully run on Leetcode :
Yes.

## Any problem you faced while coding this :
No. 

## Your code here along with comments explaining your approach
### Solution:
      class Solution:
          def evalRPN(self, tokens: List[str]) -> int:
              stack = []
              for num in tokens:
                  if num not in "+-*/":
                      stack.append(int(num))
                  elif len(stack) >=2:
                      num1 = stack.pop()
                      num2 = stack.pop()
                      if num == '+':
                          stack.append(num1+num2)
                      elif num == '-':
                          stack.append(num2-num1)
                      elif num == '*':
                          stack.append(num1*num2)
                      else:
                          stack.append(int(num2/num1))
              if stack:
                  return stack.pop()
              else:
                  return 0

# Problem 2 - Remove K Digits
## Time Complexity :
O(n)

## Space Complexity :
O(n)

## Did this code successfully run on Leetcode :
Yes.

## Any problem you faced while coding this :
No. 

## Your code here along with comments explaining your approach
### Solution:
      class Solution:
          def removeKdigits(self, num: str, k: int) -> str:
              stack=[]
              for x in num:
                  #check if x>stack[-1]
                  while stack and x<stack[-1] and k:
                      stack.pop()
                      k-=1
                  stack.append(x)
                  print(stack)
                  print(k)
              # while k!=0:
              #     stack.pop()
              #     k-=1
              print(stack)
              return "".join(stack[:len(stack)-k]).lstrip("0") or "0"
