// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public String removeKdigits(String num, int k) {
        
        int size = num.length();

        // we can delete every character in the string if k is 
        // equal to size
        if (k == size) return "0";

        Stack<Character> stack = new Stack();

        // The idea is that when traversing the stack and we see
        // a number that's less than the number at the top of the stack,
        // then we replace that number at the top with the new number
        // This is a Greedy Approach to always take the lesser number

        int counter = 0;
        while(counter < size) {

        	while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(counter)) {
        		stack.pop(); // is the next element is smaller than what's on top of the stack, then pop off the stack
        		k--;
        	}
        	stack.push(num.charAt(counter));
        	counter++;
        }

        // handle the case where the number repeats itself: 111111
        while (k > 0) {
        	stack.pop();
        	k--;
        }


        StringBuilder sb = new StringBuilder();
        
        while (!stack.isEmpty()) {
        	char current_char = stack.pop();

        	// in reverse order append it to the string builder
        	sb.append(current_char);
        }

        sb.reverse();

        // get rid of any leading zeros
        while (sb.length() > 1 && sb.charAt(0) == '0') {
        	sb.deleteCharAt(0);
        }

        return sb.toString();
    }
}

