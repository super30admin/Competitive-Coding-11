// Time complexity- O(n)
// Space complexity- O(n)
function evalRPN(tokens: string[]): number {
	const stack = [];

	for (let token of tokens) {
		if (token == "+") {
			const op2 = stack.pop(); // recent
			const op1 = stack.pop();
			stack.push(op1 + op2);
		} else if (token == "-") {
			const op2 = stack.pop(); // recent
			const op1 = stack.pop();
			stack.push(op1 - op2);
		} else if (token == "*") {
			const op2 = stack.pop(); // recent
			const op1 = stack.pop();
			stack.push(op1 * op2);
		} else if (token == "/") {
			const op2 = stack.pop(); // recent
			const op1 = stack.pop();
			stack.push(Math.trunc(op1 / op2));
		} else {
			stack.push(Number(token));
		}
	}
	return stack.pop();
}
