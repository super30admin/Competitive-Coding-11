class Solution {
    //Time Complexity:O(n)
    //Space Complexity:O(n)
   public int evalRPN(String[] tokens) {
        int result = 1;
        Stack<Integer> numbers  = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+":
            numbers.push( numbers.pop()+  numbers.pop());
                break;
                case "-":
                    int number_1 = numbers.pop();
                    int number_2 = numbers.pop();
                    numbers.push(number_2 - number_1);
                break;
                case "*":
                    numbers.push( numbers.pop() *  numbers.pop());
                break;
                case "/":
                    int number_3 = numbers.pop();
                    int number_4 = numbers.pop();
                    numbers.push(number_4 / number_3);
                break;
                default:
                    numbers.push(Integer.parseInt(token));
                    break;

            }

        }
        return numbers.pop();
    }
}
