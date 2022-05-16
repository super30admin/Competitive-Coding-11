import java.util.Stack;

//Time Complexity : O(n)
//Space Complexity : O(n)
public class RemoveKDigits {		
	/**Approach: Greedy + Stack**/
	public String removeKdigits(String num, int k) {       
        Stack<Character> st= new Stack<>();        
        for(int i=0; i<num.length(); i++){
            char digit = num.charAt(i);
            while(!st.isEmpty() && digit < st.peek() && k>0){
                k--;
                st.pop();
            }
            st.push(digit);
        }
        while(k>0){
            st.pop();
            k--;
        }
        
        //Pop all digits from stack and reverse to get least possible number after removing k digits.
        StringBuilder sb= new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();
        // System.out.println(sb);
        
        //Remove leading zeros       
        while(sb.length()>1 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }  
        
        return (sb.length() == 0) ? "0" : sb.toString();
    }
	
	// Driver code to test above
	public static void main (String[] args) {	
		RemoveKDigits ob  = new RemoveKDigits();		
		String num = "1432219";
		int k = 3;
		System.out.println("Smallest possible number after removing any "+k+" digits from "+num+" is : "+ob.removeKdigits(num, k));
	}
}
