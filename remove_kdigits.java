class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length() == k ) return "0"; //if the length of num is equal to k then return 0
        Stack<Character> stack = new Stack<>(); //initialize a stack which takes character as input
        stack.push(num.charAt(0)); //we push the first element from string array to the stack
        for(int i = 1; i < num.length(); i++) { //we go through all the elements in the string array starting from 1
            while (!stack.isEmpty() && k > 0 && stack.peek() > num.charAt(i)) { //if these conditions are satisfied
                stack.pop(); //we pop the top element
                k--; //we reduce the count of k
            }
            stack.push(num.charAt(i)); //else we push the element to the stack
        }
        while(k > 0) { //if k is greater than 0
            stack.pop(); //we pop the element from the stack
            k--; //we reduce the count
        }
        if(stack.isEmpty()) return "0"; //if stack is empty, return 0
        StringBuilder sb = new StringBuilder(); //we initialize a stringbuilder
        while(!stack.isEmpty()) { //if stack is empty
            sb.append(stack.pop()); //we append the popped elemenet from the stack to the stringbuilder
        }
        sb.reverse(); //we reverse the stringbuilder
        while(sb.length() > 1 && sb.charAt(0) == '0') { //if sb length is greater than 1 and the first element in the sb is 0
            sb.deleteCharAt(0); //we delete the element at index 0
        }
        return sb.toString(); //in the end, we return the stringbuilder in string format.
    }
}
//tc and sc -O(n)