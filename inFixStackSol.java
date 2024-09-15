/**
 * Time: O(n)
 * Space; O(n)
 * Description: push ints into stack and perform the operation on top 2 elements in the stack and then push the result back on top of the stack
 */

import java.util.*;
//in-fix notation
//input: String[]
//output: int
public class inFixStackSol {
  public static void main(String[] args) {
    int result;
    String[] test = {"4","1","+","3","*"};
    inFixSol obj = new inFixSol();
    result = obj.solver(test);
    System.out.println(result);
  } 
  
  public int solver(String [] s){
	if(s.length == 0) return 0;
	
	Stack <Integer> st = new Stack<>();

	for(String ch: s){
		int num1 = 0;
		int num2 = 0;
		int result = 0;

		if(ch.equals("+")) {
			num1 = st.pop();
			num2 = st.pop();
			result = num1 + num2;
			st.push(result);
		}
		else if(ch.equals("-")) {
			num1 = st.pop();
			num2 = st.pop();
			result = num1 - num2;
			st.push(result);
		}
		else if(ch.equals("*")) {
			num1 = st.pop();
			num2 = st.pop();
			result = num1 * num2;
			st.push(result);
		}
		else if(ch.equals("/")) {
			num1 = st.pop();
			num2 = st.pop();
			result = num1 / num2;
			st.push(result);
		}
		else{
			st.push(Integer.parseInt(ch));
		}
	}
	return st.peek();
}

}
