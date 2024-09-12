public class Solution {
    // TC : O(n)
    // SC : O(n)
    public String removeKdigits(String num, int k) {

        if (num == null || k == 0) return num;

        int n = num.length();
        Stack<Character> s = new Stack<>(); //Stack to store the least possible combination of no.'s after removing k digits
        int lvl = 0;    //To remove k digits
        StringBuilder sb = new StringBuilder(); //to give out the final output
        for (int i = 0; i < n; i++) {   //traversing through the string
            char c = num.charAt(i);

            while (!s.isEmpty() && c < s.peek() && lvl < k) {//if stack is not empty and if the character is less than the top of the stack, removing the larger elements from top of the stack till level is equal to k
                s.pop();
                lvl++;
            }
            s.push(c);  //if the current element is greater than the top of the stack, pushing the element to the top of the stack
        }

        while (lvl < k) {   //for ex=15123, if there are elements still to be removed, and level is not equal to k, we remove the top of the stack as it holds the biggest no's
            s.pop();
            lvl++;
        }

        while (!s.isEmpty()) {  //popping from the stack to form the no.
            sb.append(s.pop());
        }
        sb.reverse();   //reversing the stringbuilder to get the original order

        while (sb.length() > 0 && sb.charAt(0) == '0') {    //if there are 0's at the beginning, removing them
            sb.deleteCharAt(0);
        }
        if (sb.length() == 0) { //for eg: 10, here we remove both the elements and there the no. formed is 0, so we return 0
            return "0";
        }
        return sb.toString();   //or we return the least no. possible after removing k digits
    }
}