import java.util.Stack;

//Time Complexity=O(n)
//Space Complexity=O(n)
public class RemoveKDigits {

    public String removeKdigits(String num, int K) {

        String temp1 = String.valueOf(num);
        StringBuilder temp2 = new StringBuilder();
        int numLength = temp1.length();
        if(K == numLength) {
            return "0";
        }
        if(K == 0) {
            return num;
        }
        int index = 0;
        Stack<Integer> stack = new Stack<Integer>();
        while(index < numLength) {
            while(K > 0 && !stack.isEmpty() && stack.peek() > Character.getNumericValue(temp1.charAt(index))) {
                K--;
                stack.pop();
            }
            stack.push(Integer.parseInt(String.valueOf(temp1.charAt(index))));
            index++;
        }
        while(K > 0) {
            stack.pop();
            K--;
        }
        while(!stack.isEmpty()) {
            temp2.append(stack.remove(0));
        }
        return String.valueOf(temp2).replaceFirst("^0+(?!$)", "");
    }
}
