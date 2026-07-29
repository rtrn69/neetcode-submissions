class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            switch(tokens[i]) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                
                case "-":
                    stack.push(-stack.pop() + stack.pop());
                    break;

                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                
                case "/":
                    int divisor = stack.pop();
                    stack.push(stack.pop() / divisor);
                    break;

                default:
                    stack.push(Integer.parseInt(tokens[i]));
            }
        }

        return stack.pop();
    }
}
