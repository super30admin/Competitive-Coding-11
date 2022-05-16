import java.util.Stack;

//Time Complexity : O(n)
//Space Complexity : O(n)
public class EvaluateReversePolishNotation {		
	/**Approach: Stack**/
	public int evalRPN(String[] tokens) {
        Stack<Integer> st= new Stack<>();
        for(String s: tokens){
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
                int num2 = st.pop();
                int num1 = st.pop();
                
                if(s.equals("+")) st.push(num1 + num2);
                else if(s.equals("-")) st.push(num1 - num2);
                else if(s.equals("*")) st.push(num1 * num2);
                else st.push(num1 / num2);                
            }else{
                st.push(Integer.parseInt(s));
            }            
        }
        
        return st.pop();
    }
	
	// Driver code to test above
	public static void main (String[] args) {	
		EvaluateReversePolishNotation ob  = new EvaluateReversePolishNotation();		
		String[] tokens= {"2","1","+","3","*"};
		System.out.println("Evaluated expression is : "+ob.evalRPN(tokens));
	}
}
