import java.util.Stack;

public class problem1 {

    //SC:O(n)
    //TC:O(n)
    public String removeKdigits(String num, int k) {
        Stack<Character> stack= new Stack<>();

        for(char digit: num.toCharArray())
        {
            // remove larger digit from stack if current digit is smaller
            while (!stack.isEmpty() && k>0 && stack.peek()> digit)
            {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }
        // if k>0 , remove remaining digits from the end
        while (k>0 && !stack.isEmpty())
        {
            stack.pop();k--;
        }
        // build the result
        StringBuilder sb= new StringBuilder();
        for (char c: stack)
        {
            sb.append(c);
        }
        // remove leading 0s
        while (sb.length()>0 && sb.charAt(0)=='0')
        {
            sb.deleteCharAt(0);
        }
        return sb.length()==0 ? "0" : sb.toString();


    }

}
