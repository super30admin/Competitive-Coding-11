// Time Complexity: O(n) N times each opertaions. O(1) for all push, pop and operations.
// Space Complexity: O(d) no. of digits in the stack.
<-----Stack---->
class Solution {
    public int evalRPN(String[] tokens) {
        int a,b;
		Stack<Integer> S = new Stack<Integer>();
		for (String s : tokens) {
			if(s.equals("+")) {
				S.add(S.pop()+S.pop());
			}
			else if(s.equals("/")) {
				b = S.pop();
				a = S.pop();
				S.add(a / b);
			}
			else if(s.equals("*")) {
				S.add(S.pop() * S.pop());
			}
			else if(s.equals("-")) {
				b = S.pop();
				a = S.pop();
				S.add(a - b);
			}
			else {
				S.add(Integer.parseInt(s));
			}
		}	
		return S.pop();
	}
}

<-----Deque---->
Same as above
class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> deque = new LinkedList<>();
        for (String s: tokens) {
            if (s.equals("*") || s.equals("/") || s.equals("+") || s.equals("-")) {
                int right = deque.removeFirst();
                int left = deque.removeFirst();
                if (s.equals("*")) {
                    deque.addFirst(left * right);
                }
                if (s.equals("/")) {
                    deque.addFirst(left / right);
                }
                
                if (s.equals("+")) {
                    deque.addFirst(left + right);
                }
                
                if (s.equals("-")) {
                    deque.addFirst(left - right);
                }
                
            } else {
                deque.addFirst(Integer.valueOf(s));
            }
        }
        return deque.peekFirst();
    }
}