//Time Complexity: O(n)
//Space Complexity: O(n)
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0)
        {
            return 0;
        }

        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < tokens.length; i++)
        {
            if(!tokens[i].equals("+") && !tokens[i].equals("-") && !tokens[i].equals("*") && !tokens[i].equals("/"))
            {
                s.push(Integer.parseInt(tokens[i]));
            }
            else
            {
                int n2 = s.pop();
                int n1 = s.pop();
                if(tokens[i].equals("+"))
                {
                    s.push(n1 + n2);
                }
                else if(tokens[i].equals("-"))
                {
                    s.push(n1 - n2);
                }
                else if(tokens[i].equals("*"))
                {
                    s.push(n1 * n2);
                }
                else
                {
                    s.push(n1 / n2);
                }
            }
        }
        return s.pop();
    }
}
