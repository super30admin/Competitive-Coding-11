def removeKdigits(num: str, k: int) -> str:
    '''
        402 Remove K Digits
        https://leetcode.com/problems/remove-k-digits/

        Solution:
        1. Greedy and stack
        To minimize the resulting number, we want to maintain an increasing sequence of digits from left to right as much as possible. When you encounter a digit that is smaller than the previous one, it's beneficial to remove the larger previous digit(s) to make the overall number smaller.
        eg: "14352", k = 2
        Init: digit = 1, stack = [1]
        Read from left to right
        digit = 4, 4 < stack[-1] (=1)? No, stack = [1, 4]
        digit = 3, 3 < stack[-1] (=4)? Yes, pop and append digit. stack = [1,3]
        digit = 5, 5 < stack[-1] (3)? No, stack = [1,3,5]
        digit = 2, 2 < stack[-1] (5)? Yes, stack = [1,3,2]
        Time: O(N), Space: O(N)
    '''
    if not num:
        return 0
    N = len(num)
    val = num[0]
    stack = [val]
    for i in range(1,N):
        val = num[i]

        # only decreasing seq of digits will be popped
        while stack and int(val) < int(stack[-1]) and k > 0:
            stack.pop()
            k -= 1

        stack.append(val)

    # for increasing seq of digits, nothing has been popped yet
    # hence remove the top k digits from the stack
    # eg: if num="2469", then stack = [2, 4, 6, 9]
    if k != 0:
        stack = stack[:-k]

    new = "".join(stack).lstrip('0')
    if not new:
        new = "0"
    return new

def run_removeKdigits():
    tests = [("1432219",3,"1219"), # incr (1->4, 1->9), decr (4->3->2->2->1)
             ("10200",1,"200"), # leading 0
             ("10",2,"0"), # remove all nums
             ("14352", 2, "132"), # incr (1->4, 3->5), decr (4->3,5->2)
             ("1784",1,"174"), # increasing (1->7-8), decreasing (8->4)
             ("1784", 2, "14"), # k = 2
             ("24579",1,"2457"), # all increasing
             ("24579",2,"245"), # k = 2
    ]
    for test in tests:
        num, k, ans = test[0], test[1], test[2]
        result = removeKdigits(num, k)
        print(f"\noriginal num = {num}")
        print(f"remove k digits = {k}")
        print(f"new num (after removing k digits) = {result}")
        success = (ans == result)
        print(f"Pass: {success}")
        if not success:
            print("Failed")
            return

run_removeKdigits()