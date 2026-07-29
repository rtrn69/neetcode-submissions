class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        int operation = 0;

        for (int i = 0; i < tokens.length; i++) {
            stack.push(tokens[i]);

            if (stack.peek().equals("+")) {
                stack.pop();

                operation = Integer.parseInt(stack.pop()) + Integer.parseInt(stack.pop());
                stack.push(Integer.toString(operation));

            } else if (stack.peek().equals("-")) {
                stack.pop();

                operation = -(Integer.parseInt(stack.pop())) + Integer.parseInt(stack.pop());
                stack.push(Integer.toString(operation));

            } else if (stack.peek().equals("*")) {
                stack.pop();

                operation = Integer.parseInt(stack.pop()) * Integer.parseInt(stack.pop());
                stack.push(Integer.toString(operation));

            } else if (stack.peek().equals("/")) {
                stack.pop();
                int divisor = Integer.parseInt(stack.pop());
                operation = Integer.parseInt(stack.pop()) / divisor;

                stack.push(Integer.toString(operation));
            }
        }

        return Integer.parseInt(stack.pop());
    }
}
