#To get 2 recent numbers, we need to append the numbers to stack aand then when we encounter  sign, we need to pop 2 numberes and operate on them.
#Time Complexity: O(n)
#Space Complexity: O(n)
class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        if tokens is None or len(tokens)==0:
            return 0
        ll = list()
        for i in range(len(tokens)):
            if tokens[i].isdigit():
                ll.append(tokens[i])
            else:
                if len(ll)>=2:
                    n1 = int(ll.pop())
                    n2 = int(ll.pop())
                if tokens[i] == "+":
                    num = n1 + n2
                    ll.append(num)
                elif tokens[i] == "-":
                    num = n2 - n1
                    ll.append(num)
                elif tokens[i] == "*":
                    num = n1 * n2
                    ll.append(num)
                else:
                    num = int(n2 / n1)
                    ll.append(num)
                print(ll)
        return ll[-1]