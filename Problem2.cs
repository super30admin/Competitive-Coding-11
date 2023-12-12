public class RemoveKDigits
	{
        // Time Complexity : O(n)
        // Space Complexity : O(n)
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No 
        public string RemoveKdigits(string num, int k)
        {
            Stack<char> st = new Stack<char>();

            //push each digit to stack in monotonically increasing order
            for (int i = 0; i < num.Length; i++)
            {
                while (st.Count > 0 && k > 0 && st.Peek() > num[i])
                {
                    st.Pop();
                    k--;
                }
                st.Push(num[i]);
            }

            //if the string contains digits in increasing order, pop k from stack
            while (k > 0)
            {
                st.Pop();
                k--;
            }
            //pop remaining elements from stack to char array
            char[] charArr = new char[st.Count];
            int m = st.Count - 1;
            while (st.Count > 0)
            {
                charArr[m] = st.Pop();
                m--;
            }

            //start building string from char array by removing leading zeros
            StringBuilder str = new StringBuilder();
            bool leadingZero = true;
            for (int j = 0; j < charArr.Length; j++)
            {
                if (leadingZero && charArr[j] == '0') continue;

                leadingZero = false;
                str.Append(charArr[j]);
            }

            if (str.ToString().Length == 0) return "0";

            return str.ToString();
        }
