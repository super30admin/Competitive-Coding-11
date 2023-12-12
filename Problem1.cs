// Time Complexity : O(n)
        // Space Complexity : O(n)
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No 
        public int EvalRPN(string[] tokens)
        {
            if (tokens == null || tokens.Length == 0) return 0;
            Stack<int> st = new Stack<int>();
            int result = 0;
            for (int i = 0; i < tokens.Length; i++)
            {
                int num;
                if (int.TryParse(tokens[i], out num))
                {
                    st.Push(num);
                }
                else
                {
                    int b = st.Pop();
                    int a = st.Pop();
                    switch (tokens[i])
                    {
                        case "+":
                            result = a + b;
                            break;

                        case "-":
                            result = a - b;
                            break;

                        case "*":
                            result = a * b;
                            break;

                        case "/":
                            result = a / b;
                            break;

                        default:
                            break;
                    }
                    st.Push(Convert.ToInt32(result));
                }
            }
            return st.Pop();
        }
